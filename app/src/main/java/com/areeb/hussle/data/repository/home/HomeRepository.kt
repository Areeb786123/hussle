package com.areeb.hussle.data.repository.home

import android.util.Log
import com.areeb.hussle.data.RemoteOperations
import com.areeb.hussle.data.Resource
import com.areeb.hussle.data.models.storesModule.StoresDtoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject

class HomeRepository @Inject constructor(private val remoteOperations: RemoteOperations) {
    companion object {
        private const val TAG = "HomeRepository"
    }

    suspend fun getAllProducts(): kotlinx.coroutines.flow.Flow<Resource<List<StoresDtoItem>>> {
        return flow {
            try {
                val response = remoteOperations.getAllProducts()
                emit(response)
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getProductById(id: Int): kotlinx.coroutines.flow.Flow<Resource<StoresDtoItem>> {
        return flow<Resource<StoresDtoItem>> {
            val response = remoteOperations.getProductById(id)
            emit(response)
        }.flowOn(
            Dispatchers.IO,
        )
    }
}
