package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestJson(
    @SerialName("challenge") val challenge: String,
    @SerialName("rpId") val rpId: String? = null,
    @SerialName("allowCredentials") val allowCredentials: List<ExcludeCredentialJson>? = emptyList(),
    @SerialName("userVerification") val userVerification: String? = "preferred"
)
