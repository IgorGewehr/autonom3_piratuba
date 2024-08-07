package com.example.autonom3.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.autonom3.classes.GooglePlaces

@Composable
fun PlaceDetails(
    place: GooglePlaces,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        place.placePhotoReference?.let { photoReference ->
            Image(
                painter = rememberAsyncImagePainter(
                    model = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=$photoReference&key=YOUR_API_KEY_HERE",
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Foto do lugar",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Text(text = place.placeName, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = place.placeAddress, style = MaterialTheme.typography.bodyMedium)

            place.placeOpeningHours?.let { hours ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Horário de funcionamento:", style = MaterialTheme.typography.bodyMedium)
                hours.forEach { hour ->
                    Text(text = hour, style = MaterialTheme.typography.bodySmall)
                }
            }

            place.placeRating?.let { rating ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Avaliação: ${String.format("%.1f", rating)}", style = MaterialTheme.typography.bodyMedium)
            }
        }

        IconButton(
            onClick = onCloseClick,
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Voltar")
        }
    }
}
