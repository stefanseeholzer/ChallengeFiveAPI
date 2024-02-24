package com.example.challengefiveapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.challengefiveapi.ui.CharactersApp
import com.example.challengefiveapi.ui.theme.CharacterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CharacterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    CharactersApp()
                }
            }
        }
    }
}
