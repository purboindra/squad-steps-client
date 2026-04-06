package com.purboyndradev.squadsteps.features.squad

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.purboyndradev.squadsteps.features.components.ProgressCard
import com.purboyndradev.squadsteps.ui.theme.AppAssets
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

@Composable
fun StridersCard(modifier: Modifier = Modifier) {

    ProgressCard(
        modifier = modifier,
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
}