package com.purboyndradev.squadsteps.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserJson(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("displayName") val displayName: String
)
