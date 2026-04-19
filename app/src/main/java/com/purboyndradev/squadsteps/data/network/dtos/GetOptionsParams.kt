package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetOptionsParams(
    @SerialName("email") val email: String
)