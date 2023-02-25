package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.repositories

import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.network.RickAndMortyService
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.network.model.map
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.model.Character
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.repositories.CharactersRepository

class CharactersRepositoryImpl(private val rickAndMortyService: RickAndMortyService) :
    CharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        return rickAndMortyService.getRickAndMortyCharacter().map()
    }
}
