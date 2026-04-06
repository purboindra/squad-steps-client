package com.purboyndradev.squadsteps.features.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.purboyndradev.squadsteps.features.home.HomeScreen
import com.purboyndradev.squadsteps.features.squad.SquadScreen
import com.purboyndradev.squadsteps.ui.theme.BlackColor
import com.purboyndradev.squadsteps.ui.theme.GreyColor
import com.purboyndradev.squadsteps.ui.theme.NeutralColor
import com.purboyndradev.squadsteps.ui.theme.PrimaryColor

private sealed interface MainLevelRoute {
    val icon: ImageVector
}

private data object Home : MainLevelRoute {
    override val icon: ImageVector = Icons.Default.Home
}

private data object Squads : MainLevelRoute {
    override val icon: ImageVector = Icons.Outlined.Person
}

private data object Activity : MainLevelRoute {
    override val icon: ImageVector = Icons.Default.MoreVert
}

private val MAIN_LEVEL_ROUTES: List<MainLevelRoute> = listOf(Home, Squads, Activity)

@Composable
fun MainScreen() {
    val topLevelBackStack = remember { TopLevelBackStack<Any>(Home) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = NeutralColor,
        bottomBar = {
            NavigationBar (
                containerColor = NeutralColor,
            ) {
                MAIN_LEVEL_ROUTES.forEach { topLevelRoute ->

                    val isSelected = topLevelRoute == topLevelBackStack.topLevelKey
                    NavigationBarItem(
                        colors = NavigationBarItemColors(
                            selectedIconColor = BlackColor,
                            selectedTextColor = BlackColor,
                            unselectedIconColor = GreyColor,
                            unselectedTextColor = GreyColor,
                            selectedIndicatorColor = PrimaryColor,
                            disabledIconColor = GreyColor,
                            disabledTextColor = GreyColor
                        ),
                        selected = isSelected,
                        onClick = {
                            topLevelBackStack.addTopLevel(topLevelRoute)
                        },
                        icon = {
                            Icon(
                                imageVector = topLevelRoute.icon,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavDisplay(
            backStack = topLevelBackStack.backStack,
            onBack = {
                topLevelBackStack.removeLast()
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            entryProvider = entryProvider {
                entry<Home> {
                    HomeScreen(modifier = Modifier.fillMaxSize())
                }
                entry<Squads> {
                    SquadScreen(modifier = Modifier.fillMaxSize())
                }
                entry<Activity> {
                    Text(
                        text = "Activity",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        )
    }
}