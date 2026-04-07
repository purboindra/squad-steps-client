package com.purboyndradev.squadsteps.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.ui.theme.BlackColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor2

@Composable
fun WeeklyLeaderBoardCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(8.dp)
            )
            .background(BlackColor)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Weekly Leaderboard", style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Squads closing in on the 1 Million step milestone this week.",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = GreyColor,
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .padding(horizontal = 24.dp)
            ) {
                CircleAvatar(
                    imageUrl = "https://randomuser.me/api/portraits/men/75.jpg",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(32.dp)
                        .offset(
                            x = (-24).dp,
                        )
                        .clip(CircleShape)
                        .background(GreyColor2)
                )
                CircleAvatar(
                    imageUrl = "https://randomuser.me/api/portraits/men/45.jpg",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(32.dp)
                        .clip(CircleShape)
                        .background(GreyColor2)
                )
                CircleAvatar(
                    imageUrl = "https://randomuser.me/api/portraits/men/13.jpg",
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(32.dp)
                        .offset(
                            x = (18).dp,
                        )
                        .clip(CircleShape)
                        .background(GreyColor2)
                )
            }
        }
    }
}