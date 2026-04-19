package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.Serializable

@Serializable
data class GetOptionsResponseDto(
    val type: String,
    val options: GenerateRegisterResponseDto
)