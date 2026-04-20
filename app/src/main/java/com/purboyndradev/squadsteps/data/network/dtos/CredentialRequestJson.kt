package com.purboyndradev.squadsteps.data.network.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CredentialRequestJson(
    @SerialName("challenge") val challenge: String,
    @SerialName("rp") val rp: RpJson,
    @SerialName("user") val user: UserJson,
    @SerialName("pubKeyCredParams") val pubKeyCredParams: List<PubKeyCredParamJson>,
    @SerialName("timeout") val timeout: Long,
    @SerialName("attestation") val attestation: String,
    @SerialName("excludeCredentials") val excludeCredentials: List<ExcludeCredentialJson>,
    @SerialName("authenticatorSelection") val authenticatorSelection: AuthenticatorSelectionJson,
//    @SerialName("extensions") val extensions: ExtensionsJson?,
    @SerialName("hints") val hints: List<String>
)