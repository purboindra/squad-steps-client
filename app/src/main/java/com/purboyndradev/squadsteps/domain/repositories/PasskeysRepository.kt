package com.purboyndradev.squadsteps.domain.repositories

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterParams
import com.purboyndradev.squadsteps.data.network.dtos.GetOptionsParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyAuthParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.domain.models.GenerateRegisterOptions
import com.purboyndradev.squadsteps.domain.models.GetOptions
import com.purboyndradev.squadsteps.domain.models.TokenModel

interface PasskeysRepository {
    suspend fun generateRegisterOptions(
        params: GenerateRegisterParams
    ): Result<GenerateRegisterOptions, AppError>

    suspend fun verifyRegisterOptions(
        params: VerifyRegisterOptionsParams
    ): Result<Any, AppError>

    suspend fun getOptions(
        params: GetOptionsParams
    ): Result<GetOptions, AppError>

    suspend fun verifyAuth(
        params: VerifyAuthParams
    ): Result<TokenModel, AppError>
}