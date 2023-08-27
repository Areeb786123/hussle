package com.areeb.hussle.ui.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.areeb.hussle.ui.screens.home.screen.home
import com.areeb.hussle.ui.screens.splash.screen.splashScreen
import com.areeb.hussle.utils.CommonString.Navigations.Companion.HOME
import com.areeb.hussle.utils.CommonString.Navigations.Companion.SPLASH_SCREEN

@Composable
fun navController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = com.areeb.hussle.ui.navigations.SPLASH_SCREEN,
    ) {
        composable(HOME) {
            home(navController)
        }
        composable(SPLASH_SCREEN) {
            splashScreen(navController = navController)
        }
    }
}

const val HOME = HOME
const val SPLASH_SCREEN = SPLASH_SCREEN
