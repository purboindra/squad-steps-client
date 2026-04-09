package com.purboyndradev.squadsteps.data.network.api

import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterRequestDto
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.ResponseDto

interface PasskeysApi {
    suspend fun generateRegisterOptions(params: GenerateRegisterRequestDto): ResponseDto<GenerateRegisterResponseDto>
}