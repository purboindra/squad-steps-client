package com.purboyndradev.squadsteps.data.datasources

import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.data.network.api.PasskeysApi
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.ResponseDto
import com.purboyndradev.squadsteps.core.domain.Result
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterParams
import com.purboyndradev.squadsteps.data.network.dtos.GetOptionsParams
import com.purboyndradev.squadsteps.data.network.dtos.GetOptionsResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import com.purboyndradev.squadsteps.data.network.mapKtorExceptionToAppError

class PasskeysRemoteDataSource(private val passkeysApi: PasskeysApi) {
    suspend fun generateRegisterOptions(
        params: GenerateRegisterParams
    ): Result<ResponseDto<GenerateRegisterResponseDto>, AppError> {
        return try {
            val response = passkeysApi.generateRegisterOptions(params)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(mapKtorExceptionToAppError(e))
        }
    }

    suspend fun verifyRegisterOptions(
        params: VerifyRegisterOptionsParams
    ): Result<ResponseDto<Any>, AppError> {
        return try {
            val response = passkeysApi.verifyRegisterOptions(params)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(mapKtorExceptionToAppError(e))
        }
    }

    suspend fun getOptions(
       params: GetOptionsParams
    ): Result<ResponseDto<GetOptionsResponseDto>, AppError> {
        return try {
            val response = passkeysApi.getOptions(params)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(mapKtorExceptionToAppError(e))
        }
    }
}