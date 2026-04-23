package com.purboyndradev.squadsteps.data.repositories

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.datasources.PasskeysRemoteDataSource
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterParams
import com.purboyndradev.squadsteps.data.network.dtos.GetOptionsParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyAuthParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.domain.mapper.toDomain
import com.purboyndradev.squadsteps.domain.models.GenerateRegisterOptions
import com.purboyndradev.squadsteps.domain.models.GetOptions
import com.purboyndradev.squadsteps.domain.models.TokenModel
import com.purboyndradev.squadsteps.domain.repositories.PasskeysRepository

class PasskeysRepositoryImpl(
    private val passkeysRemoteDataSource: PasskeysRemoteDataSource
) : PasskeysRepository {
    override suspend fun generateRegisterOptions(params: GenerateRegisterParams): Result<GenerateRegisterOptions, AppError> {
        return when (val result = passkeysRemoteDataSource.generateRegisterOptions(params)) {
            is Result.Success -> {
                val data = result.data.data
                if (data != null) {
                    Result.Success(data.toDomain())
                } else {
                    Result.Error(AppError.Remote.NotFound)
                }
            }

            is Result.Error -> {
                Result.Error(result.error)
            }
        }
    }

    override suspend fun verifyRegisterOptions(params: VerifyRegisterOptionsParams): Result<Any, AppError> {
        return when (val result = passkeysRemoteDataSource.verifyRegisterOptions(params)) {
            is Result.Success -> {
                val data = result.data.data
                if (data != null) {
                    Result.Success(data)
                } else {
                    Result.Error(AppError.Remote.NotFound)
                }
            }

            is Result.Error -> {
                Result.Error(result.error)
            }
        }
    }

    override suspend fun getOptions(params: GetOptionsParams): Result<GetOptions, AppError> {
        return when (val result = passkeysRemoteDataSource.getOptions(params)) {
            is Result.Success -> {
                val data = result.data.data
                if (data != null) {
                    Result.Success(data.toDomain())
                } else {
                    Result.Error(AppError.Remote.NotFound)
                }
            }

            is Result.Error -> {
                Result.Error(result.error)
            }
        }
    }

    override suspend fun verifyAuth(params: VerifyAuthParams): Result<TokenModel, AppError> {
        return when (val result = passkeysRemoteDataSource.verifyAuth(params)) {
            is Result.Success -> {
                val data = result.data
                val token = data.data?.toDomain()
                if (token != null) {
                    Result.Success(token)
                } else {
                    Result.Error(AppError.Remote.NotFound)
                }
            }

            is Result.Error -> {
                Result.Error(result.error)
            }
        }
    }

}