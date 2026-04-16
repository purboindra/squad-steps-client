package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class PasskeyRegistrationResponseDto(
    @SerialName("id")
    val id: String,

    @SerialName("rawId")
    val rawId: String,

    @SerialName("type")
    val type: String,

    @SerialName("authenticatorAttachment")
    val authenticatorAttachment: String,

    @SerialName("response")
    val response: AuthenticatorAttestationResponseDto,

    @SerialName("clientExtensionResults")
    val clientExtensionResults: JsonObject? = null
)

@Serializable
data class AuthenticatorAttestationResponseDto(
    @SerialName("clientDataJSON")
    val clientDataJSON: String,

    @SerialName("attestationObject")
    val attestationObject: String,

    @SerialName("transports")
    val transports: List<String>,

    @SerialName("authenticatorData")
    val authenticatorData: String? = null,

    @SerialName("publicKeyAlgorithm")
    val publicKeyAlgorithm: Int? = null,

    @SerialName("publicKey")
    val publicKey: String? = null
)