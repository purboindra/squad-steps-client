package com.purboyndradev.squadsteps.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.purboyndradev.squadsteps.features.login.LoginScreen
import com.purboyndradev.squadsteps.features.main.MainScreen

@Composable
fun NavScreen() {
    val backStack = remember { mutableStateListOf<Any>(LoginRoute) }

    println("Backstack is: ${backStack.toList()}")

    NavDisplay(
        backStack = backStack,
        onBack = { 
            if (backStack.size > 1) {
                backStack.removeAt(backStack.size - 1)
            }
        },
        modifier = Modifier.fillMaxSize(),
        entryProvider = entryProvider {
            entry<LoginRoute> {
                LoginScreen(
                    onNavigate = {
                        backStack.remove(LoginRoute).apply {
                            backStack.add(MainRoute)
                        }
                    }
                )
            }
            entry<MainRoute> {
                MainScreen()
            }
        }
    )
}