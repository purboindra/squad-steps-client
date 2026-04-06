package com.purboyndradev.squadsteps.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object LoginRoute : NavKey

@Serializable
data object LeaderBoardRoute : NavKey

@Serializable
data object JoinSquadRoute : NavKey

@Serializable
data object MainRoute : NavKey