package com.purboyndradev.squadsteps.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class PasskeysModel(
    val counter: Int,
    val credentialID: String,
    val deviceName: String,
    val publicKey: String,
    val transports: List<String>
)