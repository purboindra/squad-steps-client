package com.purboyndradev.squadsteps.domain.mapper

import com.purboyndradev.squadsteps.data.network.dtos.AuthenticatorSelectionDto
import com.purboyndradev.squadsteps.data.network.dtos.ExcludeCredentialDto
import com.purboyndradev.squadsteps.data.network.dtos.ExtensionsDto
import com.purboyndradev.squadsteps.data.network.dtos.GenerateRegisterResponseDto
import com.purboyndradev.squadsteps.data.network.dtos.PubKeyCredParamDto
import com.purboyndradev.squadsteps.data.network.dtos.RpDto
import com.purboyndradev.squadsteps.data.network.dtos.UserDto
import com.purboyndradev.squadsteps.domain.models.AuthenticatorSelection
import com.purboyndradev.squadsteps.domain.models.ExcludeCredential
import com.purboyndradev.squadsteps.domain.models.Extensions
import com.purboyndradev.squadsteps.domain.models.GenerateRegisterOptions
import com.purboyndradev.squadsteps.domain.models.PubKeyCredParam
import com.purboyndradev.squadsteps.domain.models.RelyingParty
import com.purboyndradev.squadsteps.domain.models.UserInfo

fun GenerateRegisterResponseDto.toDomain(): GenerateRegisterOptions {

    return GenerateRegisterOptions(
        challenge = challenge ?: throw IllegalStateException("Missing challenge from server"),
        rp = rp?.toDomain(),
        user = user?.toDomain(),
        pubKeyCredParams = pubKeyCredParams?.map { it.toDomain() } ?: emptyList(),
        timeout = timeout ?: 60000L,
        attestation = attestation ?: "none",
        excludeCredentials = excludeCredentials?.map { it.toDomain() } ?: emptyList(),
        authenticatorSelection = authenticatorSelection?.toDomain() ?: AuthenticatorSelection(
            residentKey = "preferred",
            authenticatorAttachment = "platform",
            userVerification = "preferred",
            requireResidentKey = false
        ),
        extensions = extensions?.toDomain(),
        hints = hints ?: emptyList(),
        rpId = rpId,
        allowCredentials = allowCredentials?.map {
            com.purboyndradev.squadsteps.domain.models.AllowCredential(
                id = it.id ?: "",
                type = it.type ?: "public-key",
                transports = it.transports ?: emptyList()
            )
        },
        userVerification = userVerification
    )
}


fun RpDto.toDomain(): RelyingParty {
    return RelyingParty(
        name = name ?: "Squad Steps",
        id = id ?: "localhost"
    )
}

fun UserDto.toDomain(): UserInfo {
    return UserInfo(
        id = id ?: throw IllegalStateException("User ID is required"),
        name = name ?: throw IllegalStateException("User name is required"),
        displayName = displayName ?: name
    )
}

fun PubKeyCredParamDto.toDomain(): PubKeyCredParam {
    return PubKeyCredParam(
        alg = alg ?: -7,
        type = type ?: "public-key"
    )
}

fun AuthenticatorSelectionDto.toDomain(): AuthenticatorSelection {
    return AuthenticatorSelection(
        residentKey = residentKey ?: "preferred",
        authenticatorAttachment = authenticatorAttachment ?: "platform",
        userVerification = userVerification ?: "preferred",
        requireResidentKey = requireResidentKey ?: false
    )
}

fun ExtensionsDto.toDomain(): Extensions {
    return Extensions(
        credProps = credProps ?: false
    )
}

fun ExcludeCredentialDto.toDomain(): ExcludeCredential {
    return ExcludeCredential(
        id = id ?: "",
        type = type ?: "public-key",
        transports = transports ?: emptyList()
    )
}