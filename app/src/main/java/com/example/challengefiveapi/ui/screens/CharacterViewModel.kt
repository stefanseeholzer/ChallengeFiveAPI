package com.example.challengefiveapi.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengefiveapi.model.Character
import com.example.challengefiveapi.network.CharactersApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface CharacterUiState {
    data class Success(val characters: List<Character>) : CharacterUiState
    object Error : CharacterUiState
    object Loading : CharacterUiState
}

class CharacterViewModel : ViewModel() {
    var characterUiState: CharacterUiState by mutableStateOf(CharacterUiState.Loading)
        private set

    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch {
            characterUiState = CharacterUiState.Loading
            characterUiState = try {
                val listResult = CharactersApi.retrofitService.getCharacters()
                CharacterUiState.Success(listResult.results)
            } catch (e: IOException) {
                CharacterUiState.Error
            } catch (e: HttpException) {
                CharacterUiState.Error
            }
        }
    }
}
