package com.purboyndradev.squadsteps.domain.mapper

import com.purboyndradev.squadsteps.data.network.dtos.TokenDto
import com.purboyndradev.squadsteps.domain.models.TokenModel

fun TokenDto.toDomain(): TokenModel {
    return TokenModel(
        accessToken,
        refreshToken
    )
}