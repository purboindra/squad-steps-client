package com.purboyndradev.squadsteps.domain.services

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.network.dtos.PasskeyRegistrationResponseDto
import com.purboyndradev.squadsteps.domain.models.GenerateRegisterOptions

interface PasskeyService {
    suspend fun registerPasskey(options: GenerateRegisterOptions): Result<PasskeyRegistrationResponseDto, AppError>
}