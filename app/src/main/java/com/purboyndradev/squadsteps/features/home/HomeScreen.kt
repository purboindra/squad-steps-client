package com.purboyndradev.squadsteps.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.features.components.HeaderComponent
import com.purboyndradev.squadsteps.ui.theme.BlackColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = 18.dp,
                vertical = 12.dp
            )
    ) {
        HeaderComponent()

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(288.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(288.dp)
                    .clip(
                        CircleShape
                    )
                    .background(PrimaryColor)
            )
            Box(
                modifier = Modifier
                    .size(252.dp)
                    .clip(
                        CircleShape
                    )
                    .background(BlackColor),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        "8,420", style = MaterialTheme.typography.displayMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                        )
                    )
                    Text(
                        "STEPS TODAY", style = MaterialTheme.typography.titleMedium.copy(
                            color = GreyColor,
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        "Goal: 10,000", style = MaterialTheme.typography.titleSmall.copy(
                            color = Color.White,
                        )
                    )
                }
            }
        }

    }
}