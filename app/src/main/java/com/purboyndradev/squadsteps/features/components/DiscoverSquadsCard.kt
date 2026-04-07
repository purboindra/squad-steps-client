package com.purboyndradev.squadsteps.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.ui.theme.BlackColor
import com.purboyndradev.squadsteps.ui.theme.BlueColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor

@Composable
fun DiscoverSquadsCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(8.dp)
            )
            .background(BlackColor)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Icon(
                Icons.Outlined.Search, contentDescription = "Discover New Squads",
                tint = BlueColor,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Discover New Squads", style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Find teams in London that match your daily goal of 10,000 steps.",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = GreyColor,
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Explore Now",
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = BlueColor,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    Icons.AutoMirrored.Outlined.ArrowForward,
                    contentDescription = "Explore Now",
                    modifier = Modifier.size(14.dp),
                    tint = BlueColor
                )
            }
        }
    }
}