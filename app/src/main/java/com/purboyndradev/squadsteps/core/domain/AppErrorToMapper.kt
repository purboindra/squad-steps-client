package com.purboyndradev.squadsteps.core.domain

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.purboyndradev.squadsteps.R

fun AppError.toUiText(): UiText = when (this) {
    is AppError.Remote -> {
        when (this) {
            is AppError.Remote.NoInternet -> UiText.StringResource(R.string.err_no_internet)
            is AppError.Remote.TooManyRequests -> UiText.StringResource(R.string.err_too_many_requests)
            is AppError.Remote.Unauthorized -> UiText.StringResource(R.string.err_unauthorized)
            is AppError.Remote.NotFound -> UiText.StringResource(R.string.err_not_found)
            is AppError.Remote.RequestTimeout -> UiText.StringResource(R.string.err_request_timeout)
            is AppError.Remote.Serialization -> UiText.StringResource(R.string.err_serialization)
            is AppError.Remote.Timeout -> UiText.StringResource(R.string.err_timeout)

            is AppError.Remote.InvalidJwt -> UiText.StringResource(R.string.err_invalid_jwt)
            is AppError.Remote.InvalidOtp -> UiText.StringResource(R.string.err_invalid_otp)
            is AppError.Remote.InvalidResponse -> UiText.StringResource(R.string.err_invalid_response)
            is AppError.Remote.Network -> UiText.StringResource(R.string.err_no_internet)

            is AppError.Remote.Http ->
                if (body.isNullOrBlank() && message.isNullOrBlank())
                    UiText.StringResource(R.string.err_http_code)
                else
                    UiText.DynamicString(message ?: "Server error")

            is AppError.Remote.Unknown ->
                if (message.isNullOrBlank())
                    UiText.StringResource(R.string.err_remote_unknown)
                else
                    UiText.DynamicString(message)
        }
    }

    is AppError.Local -> {
        when (this) {
            AppError.Local.DiskFull -> UiText.StringResource(R.string.err_disk_full)
            AppError.Local.InsufficientFunds -> UiText.StringResource(R.string.err_too_many_requests)
            is AppError.Local.Unknown ->
                if (cause?.message.isNullOrBlank())
                    UiText.StringResource(R.string.err_remote_unknown)
                else
                    UiText.StringResource(R.string.err_remote_unknown_with_message)
        }
    }
}


sealed class UiText {
    data class DynamicString(val value: String) : UiText()

    class StringResource(@StringRes val resId: Int, vararg val args: Any) : UiText()

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> stringResource(resId, *args)
        }
    }

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(resId, *args)
        }
    }
}