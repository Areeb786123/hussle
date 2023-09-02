package com.areeb.hussle.ui.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.areeb.hussle.ui.common.components.bottomNavigation.BottomNavigation
import com.areeb.hussle.ui.screens.home.screen.Home
import com.areeb.hussle.ui.screens.settings.screen.Setting
import com.areeb.hussle.ui.screens.splash.screen.SplashScreen
import com.areeb.hussle.utils.CommonString

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = CommonString.Navigations.SPLASH_SCREEN,
    ) {
        composable(route = BottomNavigation.Home.route) {
            com.areeb.hussle.ui.screens.home.screen.Home(navHostController = navHostController)
        }
        composable(route = BottomNavigation.Settings.route) {
            com.areeb.hussle.ui.screens.settings.screen.Setting(navHostController = navHostController)
        }

        composable(route = CommonString.Navigations.SPLASH_SCREEN) {
            com.areeb.hussle.ui.screens.splash.screen.SplashScreen()
        }
    }
}
