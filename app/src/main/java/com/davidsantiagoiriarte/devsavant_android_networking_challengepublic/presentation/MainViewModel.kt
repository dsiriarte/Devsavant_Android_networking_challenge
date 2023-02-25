package com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.model.Character
import com.davidsantiagoiriarte.devsavant_android_networking_challengepublic.domain.repositories.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    private var _characters = MutableStateFlow<List<Character>>(listOf<Character>())
    val characters: StateFlow<List<Character>> = _characters.asStateFlow()

    private var _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()


    private var _errorConnectingToServer = MutableStateFlow<Boolean>(false)
    val errorConnectingToServer: StateFlow<Boolean> = _errorConnectingToServer.asStateFlow()

    fun fetchCharacters() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _errorConnectingToServer.value = false
                val characters = charactersRepository.getCharacters()
                _characters.value = characters
                _isLoading.value = false
            } catch (ex: Exception) {
                _errorConnectingToServer.value = true
                _isLoading.value = false
            }
        }
    }

    fun clearCharacter() {
        viewModelScope.launch {
            _characters.value = listOf()
            _errorConnectingToServer.value = false
        }
    }
}
