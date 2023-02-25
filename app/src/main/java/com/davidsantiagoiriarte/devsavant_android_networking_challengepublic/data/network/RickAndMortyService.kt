package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.network

import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.network.model.RickAndMortyApiResponse
import retrofit2.http.GET

interface RickAndMortyService {

    @GET("character")
    suspend fun getRickAndMortyCharacter(): RickAndMortyApiResponse
}
