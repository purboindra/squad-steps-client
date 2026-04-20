package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerateRegisterResponseDto(
    val challenge: String? = null,
    val rp: RpDto? = null,
    val user: UserDto? = null,
    val pubKeyCredParams: List<PubKeyCredParamDto>? = emptyList(),
    val timeout: Long?,
    val attestation: String? = null,
    val excludeCredentials: List<ExcludeCredentialDto>? = emptyList(),
    val authenticatorSelection: AuthenticatorSelectionDto? = null,
    val extensions: ExtensionsDto? = null,
    val hints: List<String>? = emptyList(),
    val rpId: String? = null,
    val userVerification: String? = null,
    val allowCredentials: List<ExcludeCredentialDto>? = emptyList(),
)

@Serializable
data class RpDto(
    @SerialName("name") val name: String?,
    @SerialName("id") val id: String?
)

@Serializable
data class UserDto(
    @SerialName("id") val id: String?,
    @SerialName("name") val name: String?,
    @SerialName("displayName") val displayName: String?
)

@Serializable
data class PubKeyCredParamDto(
    @SerialName("alg") val alg: Int?,
    @SerialName("type") val type: String?
)

@Serializable
data class AuthenticatorSelectionDto(
    @SerialName("residentKey") val residentKey: String?,
    @SerialName("authenticatorAttachment") val authenticatorAttachment: String?,
    @SerialName("userVerification") val userVerification: String?,
    @SerialName("requireResidentKey") val requireResidentKey: Boolean?
)

@Serializable
data class ExtensionsDto(
    @SerialName("credProps") val credProps: Boolean?
)

@Serializable
data class ExcludeCredentialDto(
    @SerialName("id") val id: String?,
    @SerialName("type") val type: String?,
    @SerialName("transports") val transports: List<String>? = emptyList()
)
