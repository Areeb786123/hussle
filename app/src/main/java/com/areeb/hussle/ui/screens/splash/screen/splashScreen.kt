package com.areeb.hussle.ui.screens.splash.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.areeb.hussle.R
import com.areeb.hussle.ui.common.components.basics.appLogo
import com.areeb.hussle.ui.theme.HussleTheme
import com.areeb.hussle.utils.CommonString
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController) {
    HussleTheme() {
        colorResource(id = R.color.blue)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LaunchedEffect(key1 = Unit) {
                delay(2000)
                navHostController.navigate(CommonString.Navigations.HOME)
            }
            appLogo()
        }
    }
}
