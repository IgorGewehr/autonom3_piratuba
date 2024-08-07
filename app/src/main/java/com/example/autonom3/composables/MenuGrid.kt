package com.example.autonom3.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.autonom3.classes.GooglePlaces

@Composable
fun MenuGrid(
    places: List<GooglePlaces>,
    onPlaceClick: (GooglePlaces) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedPlace by remember { mutableStateOf<GooglePlaces?>(null) }

    Box(modifier = modifier.fillMaxSize()) {
        if (places.isEmpty()) {
            Text("Nenhum lugar disponível", modifier = Modifier.align(Alignment.Center))
        } else if (selectedPlace == null) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(places) { place ->
                    PlaceGridItem(place, onPlaceClick)
                }
            }
        } else {
            PlaceDetails(
                place = selectedPlace!!,
                onCloseClick = { selectedPlace = null },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
