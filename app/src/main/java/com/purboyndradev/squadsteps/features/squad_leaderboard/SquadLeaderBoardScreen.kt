package com.purboyndradev.squadsteps.features.squad_leaderboard

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.purboyndradev.squadsteps.features.components.HeaderComponent
import com.purboyndradev.squadsteps.features.components.PodiumRow

@Composable
fun SquadLeaderBoardScreen(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 12.dp, horizontal = 18.dp),
    ) {

        item {
            HeaderComponent()
            Spacer(modifier = Modifier.height(24.dp))
            CurrentRankComponent()
            Spacer(modifier = Modifier.height(24.dp))
            PodiumRow()
            Spacer(modifier = Modifier.height(24.dp))

        }
    }
}