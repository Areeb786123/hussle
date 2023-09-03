package com.areeb.hussle.data

sealed class Resource<out T> {
    data class SUCCESS<out T>(
        val data: T,
    ) : Resource<T>()

    data class ERROR<out T>(
        val errorMessage: T,
    ) : Resource<Nothing>()

    data class LOADING<out T>(
        val loading: Boolean,
    ) : Resource<Nothing>()
}
