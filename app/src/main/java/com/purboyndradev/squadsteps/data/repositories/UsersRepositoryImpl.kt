package com.purboyndradev.squadsteps.data.repositories

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.datasources.UsersRemoteDataSource
import com.purboyndradev.squadsteps.data.network.DataNotFoundException
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.domain.repositories.UsersRepository

class UsersRepositoryImpl(
    private val remoteDataSource: UsersRemoteDataSource
) : UsersRepository {
    override suspend fun register(params: VerifyRegisterOptionsParams): Result<Any, AppError> {
        return when (val result = remoteDataSource.register(params)) {
            is Result.Success -> {
                val data = result.data
                val user = data.data ?: throw DataNotFoundException("")
                Result.Success(user)
            }

            is Result.Error -> {
                Result.Error(result.error)
            }
        }
    }
}