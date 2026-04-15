package com.purboyndradev.squadsteps.data.repositories

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.datasources.PasskeysRemoteDataSource
import com.purboyndradev.squadsteps.data.network.DataNotFoundException
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.domain.mapper.toDomain
import com.purboyndradev.squadsteps.domain.models.GenerateRegisterOptions
import com.purboyndradev.squadsteps.domain.repositories.PasskeysRepository

class PasskeysRepositoryImpl(
    private val passkeysRemoteDataSource: PasskeysRemoteDataSource
) : PasskeysRepository {
    override suspend fun generateRegisterOptions(params: GenerateRegisterParams): Result<GenerateRegisterOptions, AppError> {
        return when (val result = passkeysRemoteDataSource.generateRegisterOptions(params)) {
            is Result.Success -> {
                val data = result.data
                val options =
                    if (data.data != null) data.data.toDomain() else throw DataNotFoundException("Data not found")
                Result.Success(options)
            }

            is Result.Error -> {
                Result.Error(result.error)
            }
        }
    }

    override suspend fun verifyRegisterOptions(params: VerifyRegisterOptionsParams): Result<Any, AppError> {
        return when (val result = passkeysRemoteDataSource.verifyRegisterOptions(params)) {
            is Result.Success -> {
                val data = result.data
//                val options =
//                    if (data.data != null) data.data.toDomain() else throw DataNotFoundException("Data not found")
//                Result.Success(options)
                val passkeys = data.data ?: throw DataNotFoundException("Data not found")
                Result.Success(passkeys)
            }

            is Result.Error -> {
                Result.Error(result.error)
            }
        }
    }

}