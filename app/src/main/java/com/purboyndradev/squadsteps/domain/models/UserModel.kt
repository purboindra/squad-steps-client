package com.purboyndradev.squadsteps.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val id: String,
    val email: String,
    val userName: String,
    val currentSteps: Int,
    val passkeys: List<PasskeysModel>
)