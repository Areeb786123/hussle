package com.areeb.hussle.di

import com.areeb.hussle.data.ApiConstants.BASE_URL
import com.areeb.hussle.data.network.remote.StoresApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideStoreApi(retrofit: Retrofit): StoresApi {
        return retrofit.create(StoresApi::class.java)
    }
}
