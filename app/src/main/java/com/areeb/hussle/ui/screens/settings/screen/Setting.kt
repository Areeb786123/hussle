package com.areeb.hussle.ui.screens.settings.screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.areeb.hussle.ui.navigations.HussleNavigationBar
import com.areeb.hussle.ui.theme.HussleTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Setting(navHostController: NavHostController) {
    HussleTheme {
        Scaffold(bottomBar = {
            HussleNavigationBar(navHostController = navHostController)
        }) {
//
        }
    }
}
