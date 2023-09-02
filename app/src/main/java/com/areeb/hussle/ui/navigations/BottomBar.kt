package com.areeb.hussle.ui.navigations

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.areeb.hussle.ui.common.components.bottomNavigation.BottomNavigation

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomBar() {
    val navHostController = rememberNavController()
    Scaffold(bottomBar = {
        HussleNavigationBar(navHostController = navHostController)
    }) {
        BottomNavGraph(navHostController = navHostController)
    }
}

@Composable
fun HussleNavigationBar(navHostController: NavHostController) {
    val screenList = listOf(BottomNavigation.Home, BottomNavigation.Settings)

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    androidx.compose.material3.NavigationBar() {
        screenList.forEach {
            AddNavigationItem(
                screenItem = it,
                currentDestination = currentDestination,
                navController = navHostController,
            )
        }
    }
}

@Composable
fun RowScope.AddNavigationItem(
    screenItem: BottomNavigation,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any {
            it.route == screenItem.route
        } == true,
        onClick = {
            try {
                navController.navigate(screenItem.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            } catch (e: Exception) {
                Log.e("errorXXX", e.message.toString())
            }
        },
        icon = {
            Icon(imageVector = screenItem.icon, contentDescription = "image")
        },
    )
}
