package com.purboyndradev.squadsteps.data.network.api

import com.purboyndradev.squadsteps.data.network.dtos.RegisterUserParams
import com.purboyndradev.squadsteps.data.network.dtos.ResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams

interface UsersApi {
    suspend fun register(params: VerifyRegisterOptionsParams): ResponseDto<Any>
}