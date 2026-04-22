package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class VerifyAuthParams(
    @SerialName("email") val email: String,
    @SerialName("options") val options: VerifyAuthOptionsParams
)


@Serializable
data class VerifyAuthOptionsParams(
    val rawId: String,
    val authenticatorAttachment: String,
    val type: String,
    val id: String,
    val response: ResponseAuthOptions,
    val clientExtensionResults: JsonObject? = null
)


@Serializable
data class ResponseAuthOptions(
    val clientDataJSON: String,
    val authenticatorData: String,
    val signature: String,
    val userHandle: String
)