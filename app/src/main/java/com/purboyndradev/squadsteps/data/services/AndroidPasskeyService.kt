package com.purboyndradev.squadsteps.data.services

import android.annotation.SuppressLint
import android.content.Context
import androidx.credentials.CreateCredentialRequest
import androidx.credentials.CreatePublicKeyCredentialRequest
import androidx.credentials.CreatePublicKeyCredentialResponse
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
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
import com.purboyndradev.squadsteps.domain.models.AuthenticatorSelectionJson
import com.purboyndradev.squadsteps.domain.models.CredentialRequestJson
import com.purboyndradev.squadsteps.domain.models.ExcludeCredentialJson
import com.purboyndradev.squadsteps.domain.models.GenerateRegisterOptions
import com.purboyndradev.squadsteps.domain.models.PubKeyCredParamJson
import com.purboyndradev.squadsteps.domain.models.RpJson
import com.purboyndradev.squadsteps.domain.models.UserJson
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
                rp = RpJson(options.rp.name, options.rp.id),
                user = UserJson(options.user.id, options.user.name, options.user.displayName),
                pubKeyCredParams = options.pubKeyCredParams.map {
                    PubKeyCredParamJson(
                        it.type,
                        it.alg
                    )
                },
                timeout = options.timeout,
                attestation = options.attestation,
                excludeCredentials = options.excludeCredentials.map {
                    ExcludeCredentialJson(
                        it.id,
                        it.type,
                    )
                },
                authenticatorSelection = AuthenticatorSelectionJson(
                    options.authenticatorSelection.requireResidentKey,
                    options.authenticatorSelection.residentKey,
                    options.authenticatorSelection.userVerification,
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
}