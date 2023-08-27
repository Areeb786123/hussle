package com.areeb.hussle.ui.screens.splash.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.areeb.hussle.ui.navigations.HOME
import com.areeb.hussle.ui.common.components.appLogo
import kotlinx.coroutines.delay

@Composable
fun splashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LaunchedEffect(key1 = Unit) {
            delay(2000)
            navController.navigate(HOME)
        }
        appLogo()
    }
}
