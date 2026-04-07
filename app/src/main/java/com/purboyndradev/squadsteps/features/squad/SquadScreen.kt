package com.purboyndradev.squadsteps.features.squad

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.features.components.CircleAvatar
import com.purboyndradev.squadsteps.features.components.DiscoverSquadsCard
import com.purboyndradev.squadsteps.features.components.HeaderComponent
import com.purboyndradev.squadsteps.features.components.ProgressCard
import com.purboyndradev.squadsteps.features.components.WeeklyLeaderBoardCard
import com.purboyndradev.squadsteps.ui.theme.AppAssets
import com.purboyndradev.squadsteps.ui.theme.BlackColor
import com.purboyndradev.squadsteps.ui.theme.BlueColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor2
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

@Composable
fun SquadScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 12.dp, horizontal = 18.dp),
    ) {

        item {

            HeaderComponent()
            Spacer(modifier = Modifier.height(24.dp))
            CommunitiesCard()

            Spacer(modifier = Modifier.height(24.dp))
            ProgressCard(
                value = "3 OF 12",
                members = 24,
                steps = "84.2k",
                image = AppAssets.strider,
                title = "Midnight Striders",
                badgeColor = PrimaryColor,
                progress = {
                    0.5f
                }
            )
            Spacer(modifier = Modifier.height(24.dp))

            ProgressCard(
                value = "12 Of 89",
                members = 156,
                steps = "1.2M",
                image = AppAssets.urban,
                title = "Urban Explorers",
                badgeColor = GreyColor,
                progress = {
                    0.3f
                }
            )

            Spacer(modifier = Modifier.height(24.dp))
            ProgressCard(
                value = "1 Of 8",
                members = 8,
                steps = "56.9k",
                image = AppAssets.mountain,
                title = "Peak Performers",
                badgeColor = PrimaryColor,
                progress = {
                    0.89f
                }
            )

            Spacer(modifier = Modifier.height(24.dp))
            DiscoverSquadsCard()

            Spacer(modifier = Modifier.height(24.dp))
            WeeklyLeaderBoardCard()
        }
    }
}