package com.example.autonom3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.autonom3.pages.AppNavigation
import com.example.autonom3.ui.theme.Autonom3Theme
import com.google.android.libraries.places.api.Places

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialize o SDK do Places
        val apiKey = "AIzaSyDGoinli049ELZoi4VSvyeisvoqzNRaboY" // substitua pelo nome correto da sua chave no strings.xml
        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, apiKey)
        }

        enableEdgeToEdge()
        setContent {
            Autonom3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(context = applicationContext, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
