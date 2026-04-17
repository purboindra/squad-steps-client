package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.Serializable

@Serializable
data class PasskeyParams(
    val credentialID: String,
    val publicKey: Map<String, Int>,
    val counter: Int,
    val deviceName: String? = null,
    val transports: List<String>,
)