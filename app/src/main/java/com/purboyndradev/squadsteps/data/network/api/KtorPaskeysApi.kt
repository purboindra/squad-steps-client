package com.purboyndradev.squadsteps.data.network.api

import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterRequestDto
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.ResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendPathSegments

class KtorPaskeysApi(private val client: HttpClient) : PasskeysApi {
    override suspend fun generateRegisterOptions(params: GenerateRegisterRequestDto): ResponseDto<GenerateRegisterResponseDto> {
        return client.post {
            url {
                appendPathSegments("/api/auth/passkeys/register/options")
            }
            setBody(params)
        }.body<ResponseDto<GenerateRegisterResponseDto>>()
    }
}