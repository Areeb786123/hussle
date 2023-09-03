package com.areeb.hussle.data.models.storesModule

data class StoresDtoItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)