package com.areeb.hussle.ui.common.`fun`

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable

@Composable
fun Toast(context: Context, messege: String) {
    Toast.makeText(context, messege, Toast.LENGTH_SHORT).show()
}
