package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerifyRegisterOptionsParams(
    @SerialName("email") val email: String,
    @SerialName("id") val id: String,
    @SerialName("clientDataJSON") val clientDataJSON: String,
    @SerialName("attestationObject") val attestationObject: String,
    @SerialName("type") val type: String,
    @SerialName("transports") val transports: List<String>,

    )