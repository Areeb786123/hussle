package com.areeb.hussle.data

import com.areeb.hussle.data.models.storesModule.StoresDtoItem

interface IRemoteOperations {
    suspend fun getAllProducts(): Resource<List<StoresDtoItem>>
    suspend fun getProductById(id: Int): Resource<StoresDtoItem>
}
