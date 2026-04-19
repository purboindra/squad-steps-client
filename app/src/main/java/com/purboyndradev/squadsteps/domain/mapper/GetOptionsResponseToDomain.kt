package com.purboyndradev.squadsteps.domain.mapper

import com.purboyndradev.squadsteps.data.network.dtos.GetOptionsResponseDto
import com.purboyndradev.squadsteps.domain.models.GetOptions

fun GetOptionsResponseDto.toDomain(): GetOptions {
    return GetOptions(
        type = type,
        options = options.toDomain()
    )
}