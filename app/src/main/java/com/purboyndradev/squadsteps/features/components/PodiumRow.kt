package com.purboyndradev.squadsteps.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

@Composable
fun PodiumRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(172.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        CircleAvatarWithBadge(
            imageUrl = "https://randomuser.me/api/portraits/men/75.jpg",
            avatarSize = 80.dp,
            ringColor = Color.Gray,
            badgeColor = Color.LightGray,
            badgeContent = { Text("2", fontWeight = FontWeight.Bold) },
            userName = "Marcus",
            steps = "54,201",
        )

        CircleAvatarWithBadge(
            imageUrl = "https://randomuser.me/api/portraits/women/44.jpg",
            avatarSize = 110.dp,
            ringColor = PrimaryColor,
            badgeColor = PrimaryColor,
            badgeContent = {
                Icon(
                    Icons.Outlined.Star,
                    contentDescription = "1st",
                    tint = Color.Black,
                    modifier = Modifier.size(16.dp)
                )
            },
            userName = "Elena R",
            steps = "62,840"
        )

        CircleAvatarWithBadge(
            imageUrl = "https://randomuser.me/api/portraits/men/32.jpg",
            avatarSize = 80.dp,
            ringColor = Color(0xFFB87333),
            badgeColor = Color(0xFFD2691E),
            badgeContent = { Text("3", fontWeight = FontWeight.Bold) },
            userName = "David K",
            steps = "49,112"
        )
    }
}
