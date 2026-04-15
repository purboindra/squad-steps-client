package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.Serializable

@Serializable
data class VerifyRegisterResponseDto(
    val verified: Boolean,

    )


@Serializable
data class RegistrationInfo(
    val a: String
)