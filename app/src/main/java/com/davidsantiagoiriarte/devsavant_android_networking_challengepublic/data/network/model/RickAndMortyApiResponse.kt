package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.network.model

data class RickAndMortyApiResponse(
    val info: APIInfo,
    val results: List<APICharacter>
)

data class APIInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class APICharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String?,
    val gender: String,
    val origin: APILocation,
    val location: APILocation,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

data class APILocation(
    val name: String,
    val url: String
)
