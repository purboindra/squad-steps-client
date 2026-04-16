package com.purboyndradev.squadsteps.features.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.core.domain.toUiText
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.domain.repositories.PasskeysRepository
import com.purboyndradev.squadsteps.domain.services.PasskeyService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class LoginViewModel(
    private val passkeysRepository: PasskeysRepository,
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

    fun generateRegisterOptions(context: Context) {
        viewModelScope.launch {
            _loginState.update {
                it.copy(
                    isLoading = true
                )
            }

            val params = GenerateRegisterParams(
                _email.value
            )

            when (val result = passkeysRepository.generateRegisterOptions(params)) {
                is Result.Success -> {
                    val data = result.data

                    when (val resultPasskeys = passkeyService.registerPasskey(data)) {
                        is Result.Success -> {
                            val passkey = resultPasskeys.data
                            println("Passkeys is: $passkey")

                            val verifyRegisterOptionParams = VerifyRegisterOptionsParams(
                                email = _email.value,
                                id = passkey.id,
                                attestationObject = passkey.response.attestationObject,
                                type = passkey.type,
                                transports = passkey.response.transports,
                                clientDataJSON = passkey.response.clientDataJSON,
                                rawId = passkey.rawId,
                                clientExtensionResults = passkey.clientExtensionResults,
                            )

                            println(
                                "Verify register options params: $verifyRegisterOptionParams"
                            )

                            when (val verifyResult = passkeysRepository.verifyRegisterOptions(
                                verifyRegisterOptionParams
                            )) {
                                is Result.Success -> {
                                    println("Verify result: ${verifyResult.data}")
                                    _loginState.update {
                                        it.copy(
                                            success = true,
                                        )
                                    }
                                }

                                is Result.Error -> {
                                    val message = verifyResult.error.toUiText().asString(context)
                                    _loginState.update {
                                        it.copy(
                                            isLoading = false,
                                            error = message
                                        )
                                    }
                                    return@launch
                                }
                            }
                        }

                        is Result.Error -> {
                            val message = resultPasskeys.error.toUiText().asString(context)
                            _loginState.update {
                                it.copy(
                                    isLoading = false,
                                    error = message
                                )
                            }
                            return@launch
                        }
                    }
                }

                is Result.Error -> {
                    _loginState.update {
                        it.copy(
                            error = result.error.toUiText().asString(context)
                        )
                    }
                }
            }

            _loginState.update {
                it.copy(
                    isLoading = false
                )
            }

        }
    }

}