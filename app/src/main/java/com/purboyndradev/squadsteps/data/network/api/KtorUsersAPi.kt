package com.purboyndradev.squadsteps.data.network.api

import com.purboyndradev.squadsteps.data.network.dtos.ResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class KtorUsersAPi(private val client: HttpClient) : UsersApi {
    override suspend fun register(params: VerifyRegisterOptionsParams): ResponseDto<Any> {
        return client.post("users") {
            setBody(params)
        }.body<ResponseDto<Any>>()
    }
}