package com.areeb.hussle.data.network.remote

import com.areeb.hussle.data.ApiConstants.PRODUCTS
import com.areeb.hussle.data.models.storesModule.StoresDtoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface StoresApi {

    @GET(PRODUCTS)
    suspend fun getAllProducts(): List<StoresDtoItem>

    @GET("$PRODUCTS/{id}")
    suspend fun getProductById(@Path("id") id: Int): StoresDtoItem
}
