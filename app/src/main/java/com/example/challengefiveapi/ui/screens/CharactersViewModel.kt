package com.example.challengefiveapi.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengefiveapi.network.Character
import com.example.challengefiveapi.network.CharactersApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface CharactersUiState {
    data class Success(val data: List<Character>) : CharactersUiState
    object Error : CharactersUiState
    object Loading : CharactersUiState
}

class CharactersViewModel : ViewModel() {
    var charactersUiState: CharactersUiState by mutableStateOf(CharactersUiState.Loading)
        private set

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            charactersUiState = try {
                Log.v("", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
                // Error Under
                val listResult = CharactersApi.retrofitService.getCharacterData()
                listResult.results.forEach{ result ->
                    Log.v("", result.name)
                    Log.v("", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------")
                }
                CharactersUiState.Success(
                    listResult.results
                )
            }catch(e: IOException){
                CharactersUiState.Error
            }
        }
    }
}
