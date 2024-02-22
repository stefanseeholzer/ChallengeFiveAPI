package com.example.challengefiveapi.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengefiveapi.R
import com.example.challengefiveapi.ui.theme.ChallengeFiveAPITheme

@Composable
fun HomeScreen(
    charactersUiState: String,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    ResultScreen(charactersUiState, modifier.padding(top = contentPadding.calculateTopPadding()))
}

@Composable
fun ResultScreen(results: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = results)
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    ChallengeFiveAPITheme {
        ResultScreen(stringResource(R.string.placeholder_result))
    }
}
