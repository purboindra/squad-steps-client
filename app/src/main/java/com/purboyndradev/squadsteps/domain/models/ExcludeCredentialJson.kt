package com.purboyndradev.squadsteps.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExcludeCredentialJson(
    @SerialName("id") val id: String,
    @SerialName("type") val type: String
)
