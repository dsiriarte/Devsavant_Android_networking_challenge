package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.di

import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.network.RickAndMortyService
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.data.repositories.CharactersRepositoryImpl
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCharactersRepository(rickAndMortyService: RickAndMortyService): CharactersRepository {
        return CharactersRepositoryImpl(rickAndMortyService)
    }
}
