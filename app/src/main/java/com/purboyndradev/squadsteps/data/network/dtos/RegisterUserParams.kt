package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserParams(
    val email: String,
    val username: String,
    val profilePicture: String? = null,
    val currentSteps: Int = 0,
    val passkeys: List<PasskeyParams>,
    val groups: List<String> = emptyList(),
)