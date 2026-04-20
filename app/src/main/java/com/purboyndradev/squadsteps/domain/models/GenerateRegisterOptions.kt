package com.purboyndradev.squadsteps.domain.models

data class GenerateRegisterOptions(
    val challenge: String,
    val rp: RelyingParty? = null,
    val user: UserInfo? = null,
    val pubKeyCredParams: List<PubKeyCredParam>? = null,
    val timeout: Long,
    val attestation: String? = null,
    val excludeCredentials: List<ExcludeCredential>? = null,
    val authenticatorSelection: AuthenticatorSelection? = null,
    val extensions: Extensions?,
    val hints: List<String>,
    /// FOR LOGIN
    val allowCredentials: List<AllowCredential>? = null,
    val userVerification: String? = null
)

data class AllowCredential(
    val id: String,
    val transports: List<String>,
    val type: String,
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