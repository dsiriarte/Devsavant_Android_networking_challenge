package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.di

import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.network.RickAndMortyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRickAndMortyService(): RickAndMortyService {
        return provideRetrofit().create(RickAndMortyService::class.java)
    }
}

const val BASE_URL = "https://rickandmortyapi.com/api/"
