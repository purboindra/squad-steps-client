package com.purboyndradev.squadsteps.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AuthenticatorSelectionJson(
    @SerialName("requireResidentKey") val requireResidentKey: Boolean,
    @SerialName("residentKey") val residentKey: String,
    @SerialName("userVerification") val userVerification: String
)
