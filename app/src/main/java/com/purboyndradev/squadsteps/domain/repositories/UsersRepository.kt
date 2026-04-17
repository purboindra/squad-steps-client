package com.purboyndradev.squadsteps.domain.repositories

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams

interface UsersRepository {
    suspend fun register(params: VerifyRegisterOptionsParams): Result<Any, AppError>
}