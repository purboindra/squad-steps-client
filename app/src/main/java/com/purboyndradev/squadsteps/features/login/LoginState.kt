package com.purboyndradev.squadsteps.features.login

import androidx.compose.runtime.Stable

@Stable
data class AuthState(
    val error: String? = null,
    val success: Boolean = false,
    val isLoading: Boolean = false,
    val data: Any? = null
)
