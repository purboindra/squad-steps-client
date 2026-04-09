package com.purboyndradev.squadsteps.domain.models

data class GenerateRegisterOptions(
    val challenge: String,
    val rp: RelyingParty,
    val user: UserInfo,
    val pubKeyCredParams: List<PubKeyCredParam>,
    val timeout: Long,
    val attestation: String,
    val excludeCredentials: List<ExcludeCredential>,
    val authenticatorSelection: AuthenticatorSelection,
    val extensions: Extensions?,
    val hints: List<String>
)

data class RelyingParty(
    val name: String,
    val id: String
)

data class UserInfo(
    val id: String,
    val name: String,
    val displayName: String
)

data class PubKeyCredParam(
    val alg: Int,
    val type: String
)

data class AuthenticatorSelection(
    val residentKey: String,
    val authenticatorAttachment: String,
    val userVerification: String,
    val requireResidentKey: Boolean
)

data class Extensions(
    val credProps: Boolean
)

data class ExcludeCredential(
    val id: String,
    val type: String,
    val transports: List<String>
)