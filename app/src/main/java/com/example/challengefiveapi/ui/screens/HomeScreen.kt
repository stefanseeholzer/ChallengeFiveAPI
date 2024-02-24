package com.example.challengefiveapi.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.challengefiveapi.model.Character
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.challengefiveapi.ui.theme.CharacterTheme

@Composable
fun HomeScreen(
    characterUiState: CharacterUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (characterUiState) {
        is CharacterUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is CharacterUiState.Success -> ResultScreen(
            characterUiState.characters, modifier = modifier.fillMaxWidth()
        )
        is CharacterUiState.Error -> ErrorScreen( modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = "Loading...")
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Error!")
    }
}

@Composable
fun ResultScreen(characters: List<Character>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.padding(top = 80.dp)) {
        items(characters){character ->
            CharacterCard(character, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun CharacterCard(character: Character, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = "Image of ${character.name}",
                modifier = Modifier
                    .height(100.dp),
                alignment = Alignment.TopStart
            )
            Column {
                Text(
                    text = character.name,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                        .height(25.dp)
                )
                Text(
                    text = "Species: ${character.species}",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                        .height(25.dp)
                )
                Text(
                    text = "Gender: ${character.gender}",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                        .height(25.dp)
                )
                Text(
                    text = "Origin: ${character.origin.name}",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                        .height(25.dp)
                )
            }
        }
    }
}