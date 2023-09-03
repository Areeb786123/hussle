package com.areeb.hussle.data

import android.util.Log
import com.areeb.hussle.data.models.storesModule.StoresDtoItem
import com.areeb.hussle.data.network.remote.StoresApi
import javax.inject.Inject

class RemoteOperations @Inject constructor(private val storeApi: StoresApi) {
    companion object {
        private const val TAG = "RemoteOperations"
    }

    suspend fun getAllProducts(): Resource<List<StoresDtoItem>> {
        return try {
            val response = storeApi.getAllProducts()
            Resource.SUCCESS(response)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            Resource.ERROR(e.message.toString())
        }
    }

    suspend fun getProductById(id: Int): Resource<StoresDtoItem> {
        return try {
            val response = storeApi.getProductById(id)
            Resource.SUCCESS(response)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            Resource.ERROR(e.message.toString())
        }
    }
}
