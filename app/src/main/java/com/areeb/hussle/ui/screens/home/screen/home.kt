package com.areeb.hussle.ui.screens.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.areeb.hussle.ui.theme.HussleTheme

@Composable
fun home(navHostController: NavHostController) {
    HussleTheme {
        Surface(modifier = Modifier.fillMaxSize().background(Color.Green)) {
        }
    }
}

fun changeStatusBarColor() {
    // Change  to green
    // TODO
}
