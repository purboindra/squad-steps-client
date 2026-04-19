package com.purboyndradev.squadsteps.domain.mapper

import com.purboyndradev.squadsteps.data.network.dtos.PasskeyResponse
import com.purboyndradev.squadsteps.domain.models.PasskeysModel

fun PasskeyResponse.toDomain(): PasskeysModel {
    return PasskeysModel(
        counter = counter,
        credentialID = credentialID,
        deviceName = deviceName,
        publicKey = publicKey,
        transports = transports
    )
}