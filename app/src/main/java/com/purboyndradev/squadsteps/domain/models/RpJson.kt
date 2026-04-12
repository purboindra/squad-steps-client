package com.purboyndradev.squadsteps.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RpJson(
    @SerialName("name") val name: String,
    @SerialName("id") val id: String
)