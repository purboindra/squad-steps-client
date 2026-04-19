package com.purboyndradev.squadsteps.domain.mapper

import com.purboyndradev.squadsteps.data.network.dtos.RegisterResponseDto
import com.purboyndradev.squadsteps.domain.models.UserModel

fun RegisterResponseDto.toDomain(): UserModel {
    return UserModel(
        id = id,
        userName = username,
        email = email,
        currentSteps = currentSteps,
        passkeys = passkeys.map { it.toDomain() },
    )
}