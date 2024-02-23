package com.example.challengefiveapi.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.challengefiveapi.network.Character

@Composable
fun HomeScreen(
    charactersUiState: CharactersUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (charactersUiState) {
        is CharactersUiState.Loading -> LoadingScreen(
            modifier = modifier.fillMaxSize()
        )
        is CharactersUiState.Success -> ResultScreen(
            charactersUiState.data,
            modifier = modifier.fillMaxWidth()
        )

        else -> ErrorScreen( modifier = modifier.fillMaxSize())
    }
}

@Composable
fun ResultScreen(results: List<Character>, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        results.forEach { character ->
            Text(text = character.name)
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = "Loading...")
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text(text = "Error!")
}