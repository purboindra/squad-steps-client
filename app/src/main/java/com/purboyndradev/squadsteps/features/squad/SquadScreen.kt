package com.purboyndradev.squadsteps.features.squad

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.features.components.HeaderComponent
import com.purboyndradev.squadsteps.features.components.ProgressCard
import com.purboyndradev.squadsteps.ui.theme.AppAssets
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

@Composable
fun SquadScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 12.dp, horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        HeaderComponent()

        CommunitiesCard()

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

    }
}