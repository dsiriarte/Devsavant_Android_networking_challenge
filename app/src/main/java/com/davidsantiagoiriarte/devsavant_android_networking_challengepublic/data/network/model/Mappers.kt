package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.network.model

import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.model.Character
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.model.Location

fun RickAndMortyApiResponse.map(): List<Character> {
    return results.map {
        it.map()
    }
}

fun APICharacter.map() =
    Character(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin.map(),
        location.map(),
        image,
        episode,
        url,
        created
    )

fun APILocation.map() = Location(
    name,
    url
)
