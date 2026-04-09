package com.purboyndradev.squadsteps.features.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.purboyndradev.squadsteps.core.domain.AppError
import com.purboyndradev.squadsteps.core.domain.toUiText

@Composable
fun ErrorMessage(error: AppError) {
    val textToDisplay = error.toUiText().asString()

    Text(
        text = textToDisplay,
        color = Color.Red
    )
}