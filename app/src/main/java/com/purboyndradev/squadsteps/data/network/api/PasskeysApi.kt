package com.purboyndradev.squadsteps.data.network.api

import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterParams
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.ResponseDto

interface PasskeysApi {
    suspend fun generateRegisterOptions(params: GenerateRegisterParams): ResponseDto<GenerateRegisterResponseDto>
}