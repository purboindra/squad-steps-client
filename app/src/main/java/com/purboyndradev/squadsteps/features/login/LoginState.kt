package com.purboyndradev.squadsteps.features.login

import androidx.compose.runtime.Stable
import com.purboyndradev.squadsteps.core.domain.UiText

@Stable
data class AuthState(
    val error: UiText? = null,
    val success: Boolean = false,
    val isLoading: Boolean = false,
    val data: Any? = null
)
