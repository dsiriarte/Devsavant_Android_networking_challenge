package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.repositories

import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.model.Character

interface CharactersRepository {
    suspend fun getCharacters(): List<Character>
}
