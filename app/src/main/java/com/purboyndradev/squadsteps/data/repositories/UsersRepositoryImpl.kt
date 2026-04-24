package com.purboyndradev.squadsteps.data.repositories

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.datasources.UsersRemoteDataSource
import com.purboyndradev.squadsteps.data.network.DataNotFoundException
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.data.services.PreferenceService
import com.purboyndradev.squadsteps.domain.mapper.toDomain
import com.purboyndradev.squadsteps.domain.models.TokenModel
import com.purboyndradev.squadsteps.domain.models.UserModel
import com.purboyndradev.squadsteps.domain.repositories.UsersRepository

class UsersRepositoryImpl(
    private val remoteDataSource: UsersRemoteDataSource,
    private val preferenceService: PreferenceService
) : UsersRepository {
    override suspend fun register(params: VerifyRegisterOptionsParams): Result<TokenModel, AppError> {
        return when (val result = remoteDataSource.register(params)) {
            is Result.Success -> {
                val data = result.data
                val userDto = data.data
                if (userDto != null) {
                    val user = userDto.toDomain()

                    preferenceService.saveAccessToken(user.accessToken)
                    preferenceService.saveRefreshToken(user.refreshToken)

                    Result.Success(user)
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