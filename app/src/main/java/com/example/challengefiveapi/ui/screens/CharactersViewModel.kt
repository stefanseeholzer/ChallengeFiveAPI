package com.example.challengefiveapi.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.challengefiveapi.network.CharactersApi

class CharactersViewModel : ViewModel() {
    var charactersUiState: String by mutableStateOf("")
        private set

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            val listResult = CharactersApi.retrofitService.getCharacterData()
            charactersUiState = listResult
        }
    }
}
