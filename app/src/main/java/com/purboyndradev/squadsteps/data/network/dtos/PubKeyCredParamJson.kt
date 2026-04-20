package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PubKeyCredParamJson(
    @SerialName("type") val type: String,
    @SerialName("alg") val alg: Int
)
