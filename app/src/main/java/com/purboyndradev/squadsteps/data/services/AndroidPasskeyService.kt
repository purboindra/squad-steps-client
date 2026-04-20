package com.purboyndradev.squadsteps.data.services

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.credentials.CreatePublicKeyCredentialRequest
import androidx.credentials.CreatePublicKeyCredentialResponse
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.GetPasswordOption
import androidx.credentials.GetPublicKeyCredentialOption
import androidx.credentials.PasswordCredential
import androidx.credentials.PublicKeyCredential
import androidx.credentials.exceptions.CreateCredentialCancellationException
import androidx.credentials.exceptions.CreateCredentialException
import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.network.dtos.PasskeyRegistrationResponseDto
import com.purboyndradev.squadsteps.data.network.mapKtorExceptionToAppError
import com.purboyndradev.squadsteps.data.network.dtos.AuthenticatorSelectionJson
import com.purboyndradev.squadsteps.data.network.dtos.CredentialRequestJson
import com.purboyndradev.squadsteps.data.network.dtos.ExcludeCredentialJson
import com.purboyndradev.squadsteps.data.network.dtos.LoginPasskeyParams
import com.purboyndradev.squadsteps.domain.models.GenerateRegisterOptions
import com.purboyndradev.squadsteps.data.network.dtos.PubKeyCredParamJson
import com.purboyndradev.squadsteps.data.network.dtos.RpJson
import com.purboyndradev.squadsteps.data.network.dtos.UserJson
import com.purboyndradev.squadsteps.domain.services.PasskeyService
import kotlinx.serialization.json.Json

class AndroidPasskeyService(
    private val context: Context,
    private val credentialManager: CredentialManager
) : PasskeyService {
    @SuppressLint("PublicKeyCredential")
    override suspend fun registerPasskey(options: GenerateRegisterOptions): Result<PasskeyRegistrationResponseDto, AppError> {
        return try {
            val requestDto = CredentialRequestJson(
                challenge = options.challenge,
                rp = RpJson(options.rp?.name ?: "", options.rp?.id ?: ""),
                user = UserJson(
                    options.user?.id ?: "",
                    options.user?.name ?: "",
                    options.user?.displayName ?: ""
                ),
                pubKeyCredParams = if (options.pubKeyCredParams != null) options.pubKeyCredParams.map {
                    PubKeyCredParamJson(
                        it.type,
                        it.alg
                    )
                } else emptyList(),
                timeout = options.timeout,
                attestation = options.attestation ?: "",
                excludeCredentials = if (options.excludeCredentials != null) options.excludeCredentials.map {
                    ExcludeCredentialJson(
                        it.id,
                        it.type,
                    )
                } else emptyList(),
                authenticatorSelection = AuthenticatorSelectionJson(
                    options.authenticatorSelection?.requireResidentKey ?: false,
                    options.authenticatorSelection?.residentKey ?: "",
                    options.authenticatorSelection?.userVerification ?: "",
                ),
                hints = options.hints
            )

            val credentialManager = CredentialManager.create(context)

            val requestJsonString: String = Json.encodeToString(requestDto)

            println("[registerPasskey] requestJsonString: $requestJsonString")

            val request = CreatePublicKeyCredentialRequest(
                requestJson = requestJsonString,
            )

            val result = credentialManager.createCredential(context, request)

            if (result is CreatePublicKeyCredentialResponse) {
                val registrationResponseJson = result.registrationResponseJson
                val registrationResponse =
                    Json.decodeFromString<PasskeyRegistrationResponseDto>(registrationResponseJson)
                return Result.Success(registrationResponse)
            } else {
                return Result.Error(AppError.Local.Unknown(Exception("Unexpected credential type")))
            }
        } catch (e: CreateCredentialCancellationException) {
            println("Error [CreateCredentialCancellationException]: ${e.message}")
            Result.Error(AppError.Local.UserCanceled)
        } catch (e: CreateCredentialException) {
            println("Error [CreateCredentialException]: ${e.message}")
            Result.Error(AppError.Local.CredentialError(e.message ?: "Passkey creation failed"))
        } catch (e: Exception) {
            Result.Error(mapKtorExceptionToAppError(e))
        }
    }

    override suspend fun loginPasskey(params: LoginPasskeyParams): Result<Any, AppError> {
        try {
            val getPasswordOption = GetPasswordOption()

            val getPublicKeyCredentialOption = GetPublicKeyCredentialOption(
                requestJson = Json.encodeToString(params)
            )

            val credentialRequest = GetCredentialRequest(
                listOf(getPasswordOption, getPublicKeyCredentialOption),
            )

            println("Response login passkey: ${credentialRequest.credentialOptions}")

            return Result.Success(credentialRequest.credentialOptions)

        } catch (e: Exception) {
            println("Error while login passkey: ${e.message}")
            return Result.Error(mapKtorExceptionToAppError(e))
        }
    }

    fun handleSignIn(result: GetCredentialResponse) {
        // Handle the successfully returned credential.
        val credential = result.credential

        when (credential) {
            is PublicKeyCredential -> {
                val responseJson = credential.authenticationResponseJson
                // Share responseJson i.e. a GetCredentialResponse on your server to
                // validate and  authenticate
            }

            is PasswordCredential -> {
                val username = credential.id
                val password = credential.password
                // Use id and password to send to your server to validate
                // and authenticate
            }

            is CustomCredential -> {

            }
            else -> {
                Log.e("", "Unexpected type of credential")
            }
        }
    }
}