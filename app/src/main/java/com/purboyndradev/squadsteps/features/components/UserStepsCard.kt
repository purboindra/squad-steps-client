package com.purboyndradev.squadsteps.features.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.ui.theme.DarkGreenColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor2
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

const val CURRENT_USER = "You"

@Composable
fun UserStepsCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    userName: String,
    steps: String,
    avatarSize: Int,
    rank: Int,
    lastSync: String
) {

    val isCurrentUser = userName == CURRENT_USER

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (isCurrentUser) PrimaryColor else Color.Transparent
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(
                16.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                "$rank", style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Black,
                    color = if (isCurrentUser) DarkGreenColor else GreyColor
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircleAvatar(
                    imageUrl = imageUrl,
                    modifier = Modifier
                        .size(avatarSize.dp)
                        .clip(CircleShape)
                        .background(GreyColor2)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        userName, style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = if (isCurrentUser) DarkGreenColor else Color.White
                        )
                    )
                    Text(
                        lastSync,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = if (isCurrentUser) DarkGreenColor else GreyColor
                        )
                    )
                }
            }

            Box(modifier = Modifier.width(56.dp)) {
                Column(
                    horizontalAlignment = Alignment.End,
                ) {
                    Text(
                        steps, style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Black,
                            color = if (isCurrentUser) DarkGreenColor else Color.White
                        )
                    )

                    if (isCurrentUser) Text(
                        "STEPS", style = MaterialTheme.typography.bodySmall.copy(
                            color = DarkGreenColor
                        )
                    )
                }
            }

        }
    }
}