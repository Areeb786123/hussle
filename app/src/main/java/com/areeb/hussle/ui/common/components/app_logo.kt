package com.areeb.hussle.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.areeb.hussle.R

@Composable
fun appLogo(size: Dp = 146.dp) {
    Image(
        painter = painterResource(id = R.drawable.baseline_local_fire_department_24),
        contentDescription = "icon",
        modifier = Modifier.padding(10.dp).size(size = size),
    )
}
