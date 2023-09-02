package com.areeb.hussle.ui.navigations

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.areeb.hussle.R
import com.areeb.hussle.utils.CommonString

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HussleNavigationBar(navHostController: NavHostController) {
    val screenList = listOf(
        BottomNaModel(
            title = "home",
            routes = CommonString.Navigations.HOME,
            selectedImage = Icons.Default.Home,
            unSelectedImage = Icons.Outlined.Home,
        ),
        BottomNaModel(
            title = "setting",
            routes = CommonString.Navigations.SETTINGS,
            selectedImage = Icons.Default.Settings,
            unSelectedImage = Icons.Outlined.Settings,
        ),
    )

    val navBackStackEntry = navHostController.currentBackStackEntry

    androidx.compose.material3.NavigationBar(containerColor = colorResource(id = R.color.searchBar)) {
        screenList.forEach {
            val currentDestination = navBackStackEntry
            AddNavigationItem(
                screenItem = it,
                currentDestination = currentDestination,
                navController = navHostController,
            )
        }
    }
}

/*
* Added Row Scope before AddNavigation function because NavigationBarItem
* worked under RowScope Only
* */
@Composable
fun RowScope.AddNavigationItem(
    screenItem: BottomNaModel,
    currentDestination: NavBackStackEntry?,
    navController: NavHostController,
) {
    NavigationBarItem(
        selected = screenItem.routes == currentDestination?.destination?.route,
        onClick = {
            try {
                navController.navigate(screenItem.routes)
            } catch (e: Exception) {
                Log.e("errorXXX", e.message.toString())
            }
        },
        icon = {
            Icon(imageVector = screenItem.selectedImage, contentDescription = "image")
        },
    )
}
