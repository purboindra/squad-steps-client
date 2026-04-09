package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerateRegisterResponseDto(
    @SerialName("challenge") val challenge: String?,
    @SerialName("rp") val rp: RpDto?,
    @SerialName("user") val user: UserDto?,
    @SerialName("pubKeyCredParams") val pubKeyCredParams: List<PubKeyCredParamDto>? = emptyList(),
    @SerialName("timeout") val timeout: Long?,
    @SerialName("attestation") val attestation: String?,
    @SerialName("excludeCredentials") val excludeCredentials: List<ExcludeCredentialDto>? = emptyList(),
    @SerialName("authenticatorSelection") val authenticatorSelection: AuthenticatorSelectionDto?,
    @SerialName("extensions") val extensions: ExtensionsDto?,
    @SerialName("hints") val hints: List<String>? = emptyList()
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
