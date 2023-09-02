package com.areeb.hussle.ui.common.components.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.areeb.hussle.utils.CommonString

sealed class BottomNavigation(val title: String, val route: String, val icon: ImageVector) {
    object Home : BottomNavigation(
        route = CommonString.Navigations.HOME,
        title = "home",
        icon = Icons.Default.Home,
    )

    object Settings : BottomNavigation(
        route = CommonString.Navigations.SETTINGS,
        title = "settings",
        icon = Icons.Default.Settings,
    )
}
