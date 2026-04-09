package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto<T : Any>(
    val code: String? = null,
    val message: String,
    val data: T? = null,
)