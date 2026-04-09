package com.purboyndradev.squadsteps.domain.repositories

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterRequestDto
import com.purboyndradev.squadsteps.domain.models.GenerateRegisterOptions

interface PasskeysRepository {
    suspend fun generateRegisterOptions(
        params: GenerateRegisterRequestDto
    ): Result<GenerateRegisterOptions, AppError>
}