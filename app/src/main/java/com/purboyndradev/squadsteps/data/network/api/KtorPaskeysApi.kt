package com.purboyndradev.squadsteps.data.network.api

import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterParams
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.GetOptionsParams
import com.purboyndradev.squadsteps.data.network.dtos.GetOptionsResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.ResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.VerifyAuthParams
import com.purboyndradev.squadsteps.data.network.dtos.VerifyRegisterOptionsParams
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendPathSegments

class KtorPaskeysApi(private val client: HttpClient) : PasskeysApi {
    override suspend fun generateRegisterOptions(params: GenerateRegisterParams): ResponseDto<GenerateRegisterResponseDto> {
        return client.post("auth/passkeys/register/options") {
            setBody(params)
        }.body<ResponseDto<GenerateRegisterResponseDto>>()
    }

    override suspend fun verifyRegisterOptions(params: VerifyRegisterOptionsParams): ResponseDto<Any> {
        return client.post("auth/passkeys/register/verify") {
            setBody(params)
        }.body<ResponseDto<Any>>()
    }

    override suspend fun getOptions(params: GetOptionsParams): ResponseDto<GetOptionsResponseDto> {
        return client.post("auth/passkeys/get/options") {
            setBody(
                params
            )
        }.body<ResponseDto<GetOptionsResponseDto>>()
    }

    override suspend fun verifyAuth(params: VerifyAuthParams): ResponseDto<Any> {
        return client.post("auth/passkeys/verify/response") {
            setBody(params)
        }.body<ResponseDto<Any>>()
    }

}