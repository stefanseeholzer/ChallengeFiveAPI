
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.challengefiveapi.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.challengefiveapi.R
import com.example.challengefiveapi.ui.screens.HomeScreen
import com.example.challengefiveapi.ui.screens.CharactersViewModel

@Composable
fun CharactersApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { CharactersTopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val charactersViewModel: CharactersViewModel = viewModel()
            HomeScreen(
                charactersUiState = charactersViewModel.charactersUiState,
                contentPadding = it,
            )
        }
    }
}

@Composable
fun CharactersTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}
