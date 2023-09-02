package com.areeb.hussle.ui.screens.splash.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.areeb.hussle.R
import com.areeb.hussle.ui.common.components.basics.appLogo
import com.areeb.hussle.ui.theme.HussleTheme
import com.areeb.hussle.utils.CommonString.Navigations.Companion.HOME
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    HussleTheme() {
        val navHostController = rememberNavController()
        colorResource(id = R.color.blue)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LaunchedEffect(key1 = Unit) {
                delay(2000)
                navHostController.navigate(HOME)
            }
            appLogo()
        }
    }
}
