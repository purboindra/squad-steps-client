package com.purboyndradev.squadsteps.features.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.core.domain.toUiText
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterParams
import com.purboyndradev.squadsteps.data.network.dtos.GetOptionsParams
import com.purboyndradev.squadsteps.data.network.dtos.LoginPasskeyParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyAuthOptionsParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyAuthParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.domain.repositories.PasskeysRepository
import com.purboyndradev.squadsteps.domain.repositories.UsersRepository
import com.purboyndradev.squadsteps.domain.services.PasskeyService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class LoginViewModel(
    private val passkeysRepository: PasskeysRepository,
    private val usersRepository: UsersRepository,
    private val passkeyService: PasskeyService
) : ViewModel() {

    private val _loginState = MutableStateFlow(AuthState())
    val loginState = _loginState.asStateFlow()

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    fun onEmailUpdate(value: String) {
        _email.update {
            value
        }
    }

    fun getOptions() {
        viewModelScope.launch {
            _loginState.update { it.copy(isLoading = true, error = null) }

            val params = GetOptionsParams(
                _email.value
            )

            val response = passkeysRepository.getOptions(params)

            if (response is Result.Error) {
                _loginState.update {
                    it.copy(
                        isLoading = false,
                        error = response.error.toUiText()
                    )
                }
                return@launch
            }

            val responseOptions = (response as Result.Success).data

            val type = responseOptions.type

            if (type == "REGISTER") {
                generateRegisterOptions()
            } else {
                println("Type is LOGIN: ${responseOptions.options}")

                val options = responseOptions.options

                val allowCredentials = options.allowCredentials?.map {
                    it.id
                }

                val params = LoginPasskeyParams(
                    challenge = options.challenge,
                    allowCredentials = allowCredentials ?: emptyList(),
                    rpId = options.rpId ?: options.rp?.id ?: "",
                )

                when (val loginResult = passkeyService.loginPasskey(params)) {
                    is Result.Success -> {
                        verifyAuth(loginResult.data)
                    }

                    is Result.Error -> {
                        _loginState.update {
                            it.copy(
                                isLoading = false,
                                error = loginResult.error.toUiText()
                            )
                        }
                    }
                }
            }
        }
    }

    suspend fun verifyAuth(options: VerifyAuthOptionsParams) {
        val email = _email.value

        val verifyParams = VerifyAuthParams(
            email,
            options
        )

        when (val result = passkeysRepository.verifyAuth(verifyParams)) {
            is Result.Success -> {
                val data = result.data
                println("Result verify auth: $data")
                _loginState.update {
                    it.copy(
                        isLoading = false,
                        success = true
                    )
                }
            }

            is Result.Error -> {
                _loginState.update {
                    it.copy(
                        isLoading = false,
                        error = result.error.toUiText()
                    )
                }
                return
            }
        }

    }

    suspend fun generateRegisterOptions() {

        val params = GenerateRegisterParams(_email.value)

        val optionsResult = passkeysRepository.generateRegisterOptions(params)
        if (optionsResult is Result.Error) {
            _loginState.update {
                it.copy(
                    isLoading = false,
                    error = optionsResult.error.toUiText()
                )
            }
            return
        }

        val optionsData = (optionsResult as Result.Success).data

        val passkeyResult = passkeyService.registerPasskey(optionsData)
        if (passkeyResult is Result.Error) {
            _loginState.update {
                it.copy(isLoading = false, error = passkeyResult.error.toUiText())
            }
            return
        }

        val passkey = (passkeyResult as Result.Success).data
        val verifyParams = VerifyRegisterOptionsParams(
            email = _email.value,
            id = passkey.id,
            attestationObject = passkey.response.attestationObject,
            type = passkey.type,
            transports = passkey.response.transports,
            clientDataJSON = passkey.response.clientDataJSON,
            rawId = passkey.rawId,
            clientExtensionResults = passkey.clientExtensionResults,
        )

        val verifyResult = usersRepository.register(verifyParams)

        println("Verify result: ${verifyResult is Result.Error}")

        if (verifyResult is Result.Error) {
            _loginState.update {
                it.copy(isLoading = false, error = verifyResult.error.toUiText())
            }
            return
        }

        _loginState.update {
            it.copy(isLoading = false, success = true)
        }
    }
}