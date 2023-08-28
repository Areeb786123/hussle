package com.areeb.hussle.ui.screens.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.areeb.hussle.R
import com.areeb.hussle.ui.theme.HussleTheme

@Composable
fun home(navHostController: NavHostController) {
    HussleTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
        ) {
            greetUser()
            searchBar()
        }
    }
}

@Composable
fun greetUser() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.man),
            contentDescription = "image",
            modifier = Modifier
                .padding(start = 1.dp)
                .width(68.dp)
                .height(58.dp),

        )
        Text(
            text = ContextCompat.getString(LocalContext.current, R.string.greetings),
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 18.dp, start = 20.dp),
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Default,
        )
    }
}

@Preview
@Composable
fun searchBar() {
    Card(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 20.dp, start = 10.dp, end = 10.dp)
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

                modifier = Modifier.padding(start = 10.dp, top = 14.dp).weight(1f),
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
