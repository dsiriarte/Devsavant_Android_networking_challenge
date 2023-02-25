package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic

import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.model.Character
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.repositories.CharactersRepository
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.presentation.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.net.UnknownHostException

class ViewModelTest {

    val fakeList = listOf(rick, morty)

    private val fakeCharacterRepository = object : CharactersRepository {
        override suspend fun getCharacters(): List<Character> {
            return fakeList
        }
    }

    private val fakeFailingCharacterRepository = object : CharactersRepository {
        override suspend fun getCharacters(): List<Character> {
            throw UnknownHostException()
        }
    }


    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun `should fetch characters correctly`() = runBlocking {
        val viewModel = MainViewModel(fakeCharacterRepository)
        viewModel.fetchCharacters()

        //Characters
        val characters = viewModel.characters.first()
        assert(characters == fakeList)

        //Loading
        val isLoading = viewModel.isLoading.first()
        assert(!isLoading)

        //Error Connecting
        val errorConnectingToServer = viewModel.errorConnectingToServer.first()
        assert(!errorConnectingToServer)
    }


    @Test
    fun `should show error when fetch fail`() = runBlocking {
        val viewModel = MainViewModel(fakeFailingCharacterRepository)
        viewModel.fetchCharacters()

        //Error Connecting
        val errorConnectingToServer = viewModel.errorConnectingToServer.dropWhile {
            false
        }.first()
        assert(errorConnectingToServer)
    }


    @Test
    fun `should clear characters correctly`() = runBlocking {
        val viewModel = MainViewModel(fakeCharacterRepository)
        viewModel.clearCharacter()

        //Characters
        val characters = viewModel.characters.first()
        assert(characters.isEmpty())

        //Loading
        val isLoading = viewModel.isLoading.first()
        assert(!isLoading)

        //Error Connecting
        val errorConnectingToServer = viewModel.errorConnectingToServer.first()
        assert(!errorConnectingToServer)
    }

}
