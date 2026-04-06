package com.purboyndradev.squadsteps.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BadgeComponent(
    modifier: Modifier = Modifier,
    value: String,
    color: Color
) {
    Box(
        modifier = modifier

            .clip(
                RoundedCornerShape(4.dp)
            )
            .background(
                color.copy(
                    alpha = 0.5f
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            value, style = MaterialTheme.typography.titleSmall.copy(
                color = color
            ),
            modifier = Modifier.padding(vertical = 2.dp, horizontal = 4.dp)
        )
    }
}