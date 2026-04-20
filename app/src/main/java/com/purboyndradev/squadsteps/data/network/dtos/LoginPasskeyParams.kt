package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.Serializable

@Serializable
data class LoginPasskeyParams(
    val challenge: String,
    val allowCredentials: List<String>,
    val rpId: String
)