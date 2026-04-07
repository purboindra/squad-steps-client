package com.purboyndradev.squadsteps.features.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.ui.theme.DarkGreenColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    icon: @Composable (() -> Unit)? = null,
    label: String,
) {
    ElevatedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = ButtonColors(
            containerColor = PrimaryColor,
            contentColor = DarkGreenColor,
            disabledContainerColor = GreyColor,
            disabledContentColor = Color.White,
        )
    ) {
        Row {
            if (icon != null) {
                icon()
                Spacer(modifier = Modifier.width(12.dp))
            }
            Text(
                label,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = DarkGreenColor
                )
            )
        }
    }
}