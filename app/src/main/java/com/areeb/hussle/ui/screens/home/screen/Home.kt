package com.areeb.hussle.ui.screens.home.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.areeb.hussle.R
import com.areeb.hussle.data.models.storesModule.StoresDtoItem
import com.areeb.hussle.ui.common.components.basics.status_color_changer
import com.areeb.hussle.ui.navigations.HussleNavigationBar
import com.areeb.hussle.ui.screens.home.viewModels.HomeViewModels
import com.areeb.hussle.ui.theme.HussleTheme
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

private const val TAG = "Home Screen"

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navHostController: NavHostController) {
    val homeViewModels: HomeViewModels = hiltViewModel()
    homeViewModels.getAllProducts()
    val productList = homeViewModels.productItem.collectAsState()
    val resource = homeViewModels.loading.collectAsState()
    HussleTheme {
        status_color_changer(color = colorResource(id = R.color.searchBar))
        Scaffold(
            containerColor = colorResource(id = R.color.card),
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
                    com.areeb.hussle.ui.screens.home.screen.productList(productList)
                }
            },

            bottomBar = {
                HussleNavigationBar(navHostController = navHostController)
            },

        )
    }
}

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

@Composable
fun productList(productList: State<List<StoresDtoItem>>) {
    LazyColumn() {
        items(productList.value) {
            productListItem(productList = it)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun productListItem(productList: StoresDtoItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .clip(
                RoundedCornerShape(12.dp),
            ).shadow(10.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.white)),
        elevation = CardDefaults.cardElevation(20.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            GlideImage(
                model = productList.image,
                contentDescription = "image",
                modifier = Modifier.padding(start = 10.dp, top = 20.dp, bottom = 20.dp)
                    .fillMaxWidth().height(140.dp),
            ) {
                it.load(productList.image)
            }

            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = productList.title,
                modifier = Modifier.wrapContentWidth().wrapContentHeight().padding(10.dp),
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.heart_svgrepo_com),
                    contentDescription = "image",
                    modifier = Modifier.height(30.dp).width(30.dp).padding(top = 10.dp),
                )
                Card(
                    colors = CardDefaults.cardColors(colorResource(id = R.color.cart_button)),
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(10.dp).wrapContentHeight().wrapContentWidth(),
                ) {
                    Row(modifier = Modifier.padding(10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_shopping_bag_24),
                            contentDescription = "image",
                        )
                        Text(
                            text = "Add to Cart",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(start = 10.dp, top = 4.dp),
                        )
                    }
                }
            }
        }
    }
}
