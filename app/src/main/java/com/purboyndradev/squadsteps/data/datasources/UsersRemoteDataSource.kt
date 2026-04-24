package com.purboyndradev.squadsteps.data.datasources

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.network.api.UsersApi
import com.purboyndradev.squadsteps.data.network.dtos.RegisterResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.ResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.TokenDto
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.data.network.mapKtorExceptionToAppError

class UsersRemoteDataSource(private val usersApi: UsersApi) {
    suspend fun register(params: VerifyRegisterOptionsParams): Result<ResponseDto<TokenDto>, AppError> {
        return try {
            val result = usersApi.register(params)
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(mapKtorExceptionToAppError(e))
        }
    }
}