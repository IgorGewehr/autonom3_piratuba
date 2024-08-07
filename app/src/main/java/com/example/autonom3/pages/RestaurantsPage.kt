package com.example.autonom3.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.autonom3.classes.GooglePlaces
import com.example.autonom3.classes.RestaurantsViewModel
import com.example.autonom3.composables.MenuGrid
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun RestaurantsPage(navController: NavController) {
    val viewModel: RestaurantsViewModel = viewModel() // Obtém o ViewModel

    val restaurants by viewModel.restaurants.collectAsState() // Obtém a lista de restaurantes

    // Inicializa os restaurantes se necessário
    LaunchedEffect(Unit) {
        viewModel.fetchRestaurants() // Função que deve preencher a lista de restaurantes
    }

    MenuGrid(
        places = restaurants,
        onPlaceClick = { place ->
            navController.navigate("placeDetails/${place.placeId}") // Ajuste para a navegação de detalhes
        },
        modifier = Modifier.fillMaxSize()
    )
}
