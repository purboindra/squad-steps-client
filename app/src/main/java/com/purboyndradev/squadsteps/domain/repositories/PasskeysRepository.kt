package com.purboyndradev.squadsteps.domain.repositories

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.domain.models.GenerateRegisterOptions

interface PasskeysRepository {
    suspend fun generateRegisterOptions(
        params: GenerateRegisterParams
    ): Result<GenerateRegisterOptions, AppError>
    suspend fun verifyRegisterOptions(
        params: VerifyRegisterOptionsParams
    ): Result<Any, AppError>
}