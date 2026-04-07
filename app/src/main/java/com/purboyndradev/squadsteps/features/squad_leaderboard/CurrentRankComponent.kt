package com.purboyndradev.squadsteps.features.squad_leaderboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

@Composable
fun CurrentRankComponent(modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.weight(0.8f)) {
            Text(
                "Squad Leaderboard", style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            )
            Text(
                "Weekly Challenge: Oct 23 - Oct 30",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = GreyColor
                )
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                "#4", style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Black,
                    color = PrimaryColor
                )
            )
            Text(
                "YOUR RANK",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = GreyColor
                )
            )
        }
    }
}