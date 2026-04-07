package com.purboyndradev.squadsteps.features.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


data class Podium(
    val id: Int,
    val imageUrl: String,
    val userName: String,
    val steps: String,
    val lastSync: String
)

val users: List<Podium> = listOf(
    Podium(
        id = 4,
        imageUrl = "https://randomuser.me/api/portraits/men/75.jpg",
        userName = "You",
        steps = "42,509",
        lastSync = "PERSONAL BEST PACE"
    ),
    Podium(

        id = 5,
        imageUrl = "https://randomuser.me/api/portraits/men/56.jpg",
        userName = "Marcus",
        steps = "41,201",
        lastSync = "Synced 2 mins ago"
    ),
    Podium(

        id = 6,
        imageUrl = "https://randomuser.me/api/portraits/women/45.jpg",
        userName = "Sarah Chen",
        steps = "41,150",
        lastSync = "Synced 10 mins ago"
    ),
    Podium(
        id = 7,
        imageUrl = "https://randomuser.me/api/portraits/women/32.jpg",
        userName = "Mia Lopez",
        steps = "38,782",
        lastSync = "Synced 1 hour ago"
    )
)

@Composable
fun PodiumList(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        users.forEach { user ->
            UserStepsCard(
                imageUrl = user.imageUrl,
                userName = user.userName,
                steps = user.steps,
                avatarSize = 48,
                rank = user.id,
                lastSync = user.lastSync
            )
        }
    }
}