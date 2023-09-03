package com.areeb.hussle.ui.screens.home.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.areeb.hussle.R
import com.areeb.hussle.ui.common.components.basics.status_color_changer
import com.areeb.hussle.ui.navigations.HussleNavigationBar
import com.areeb.hussle.ui.screens.home.viewModels.HomeViewModels
import com.areeb.hussle.ui.theme.HussleTheme

private const val TAG = "Home Screen"

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navHostController: NavHostController) {
    HussleTheme {
        val homeViewModels: HomeViewModels = viewModel()
        homeViewModels.getAllProducts()
        status_color_changer(color = colorResource(id = R.color.searchBar))
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                            },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_menu_24),
                                contentDescription = "Hello",
                            )
                        }
                    },

                    actions = {
                        IconButton(
                            onClick = { Log.e(TAG, "alarm") },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_bedtime_24),
                                contentDescription = "image",
                            )
                        }

                        IconButton(
                            onClick = { Log.e(TAG, "alarm") },
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.man),
                                contentDescription = "image",
                            )
                        }
                    },

                    title = {
                        Text(
                            text = "Hussle",
                            fontFamily = FontFamily.Serif,
                            fontSize = 30.sp,
                            color = colorResource(id = R.color.black),
                        )
                    },
                    colors = TopAppBarDefaults.largeTopAppBarColors(colorResource(id = R.color.searchBar)),

                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    containerColor = colorResource(id = R.color.searchBar),

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.broken_heart),
                        contentDescription = "floating Button",
                    )
                }
            },

            content = {
                Column(modifier = Modifier.padding(top = 60.dp)) {
                    searchBar()
                }
            },

            bottomBar = {
                HussleNavigationBar(navHostController = navHostController)
            },

        )
    }
}

@Preview
@Composable
fun searchBar() {
    Card(
        modifier = Modifier
            .requiredHeight(100.dp)
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 20.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(colorResource(id = R.color.searchBar)),
        elevation = CardDefaults.cardElevation(1.dp).also {
            CardDefaults.elevatedCardColors(
                colorResource(id = R.color.black),
            )
        },

        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = "Search Here",

                modifier = Modifier
                    .padding(start = 10.dp, top = 14.dp)
                    .weight(1f),
                color = colorResource(id = R.color.black),
            )

            /*
            *To align Icon on center on center I  have  to give weight in text
            * */
            Image(
                painter = painterResource(id = R.drawable.mic),
                contentDescription = "image",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .padding(top = 14.dp, end = 20.dp),

            )
        }
    }
}
