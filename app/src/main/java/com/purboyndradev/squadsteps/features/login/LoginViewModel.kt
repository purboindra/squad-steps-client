package com.purboyndradev.squadsteps.features.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.core.domain.toUiText
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterRequestDto
import com.purboyndradev.squadsteps.domain.repositories.PasskeysRepository
import com.purboyndradev.squadsteps.domain.services.PasskeyService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val passkeysRepository: PasskeysRepository,
    private val passkeyService: PasskeyService
) : ViewModel() {

    private val _loginState = MutableStateFlow<AuthState>(AuthState())
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

            val params = GenerateRegisterRequestDto(
                _email.value
            )

            when (val result = passkeysRepository.generateRegisterOptions(params)) {
                is Result.Success -> {
                    val data = result.data

                    when (val resultPasskeys = passkeyService.registerPasskey(data)) {
                        is Result.Success -> {
                            val passkeys = resultPasskeys.data
                            println("Passkeys is: $passkeys")
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