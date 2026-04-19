package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PasskeyResponse(
    val counter: Int,
    val credentialID: String,
    val deviceName: String,
    val publicKey: String,
    val transports: List<String>,
)

@Serializable
data class RegisterResponseDto(
    @SerialName("_id") val id: String,
    val email: String,
    val username: String,
    val createdAt: String,
    val updatedAt: String,
    val currentSteps: Int,
    val passkeys: List<PasskeyResponse>
)