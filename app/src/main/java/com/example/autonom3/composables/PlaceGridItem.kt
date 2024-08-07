package com.example.autonom3.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.autonom3.classes.GooglePlaces

@Composable
fun PlaceGridItem(place: GooglePlaces, onPlaceClick: (GooglePlaces) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPlaceClick(place) }
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box {
            place.placePhotoReference?.let { photoReference ->
                Image(
                    painter = rememberAsyncImagePainter(
                        model = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=$photoReference&key=YOUR_API_KEY_HERE",
                        contentScale = ContentScale.Crop
                    ),
                    contentDescription = "Foto do lugar",
                    modifier = Modifier.fillMaxSize()
                )
            }

            place.placeRating?.let { rating ->
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(4.dp))
                ) {
                    Text(
                        text = String.format("%.1f", rating),
                        color = Color.White,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}
