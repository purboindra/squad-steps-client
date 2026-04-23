package com.purboyndradev.squadsteps.domain.models

import kotlinx.serialization.Serializable

data class TokenModel(
    val accessToken: String,
    val refreshToken: String
)