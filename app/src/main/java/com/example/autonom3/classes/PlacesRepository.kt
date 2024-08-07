import android.content.Context
import com.example.autonom3.classes.GooglePlaces
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse
import com.google.android.libraries.places.api.net.PlacesClient
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class PlacesRepository(private val context: Context) {

    private val placesClient: PlacesClient = Places.createClient(context)

    suspend fun fetchPlaces(query: String): List<GooglePlaces> {
        val request = FindAutocompletePredictionsRequest.builder()
            .setQuery(query)
            .build()

        val places = getAutocompletePredictions(request)
        return coroutineScope {
            val placesWithDetails = places.map { place ->
                async { fetchPlaceDetails(place.placeId) }
            }.awaitAll()
            placesWithDetails
        }
    }

    private suspend fun getAutocompletePredictions(request: FindAutocompletePredictionsRequest): List<GooglePlaces> {
        return suspendCoroutine { continuation ->
            placesClient.findAutocompletePredictions(request)
                .addOnSuccessListener { response: FindAutocompletePredictionsResponse ->
                    val places = response.autocompletePredictions.mapNotNull { prediction ->
                        val placeId = prediction.placeId ?: return@mapNotNull null

                        GooglePlaces(
                            placeId = placeId,
                            placeName = prediction.getPrimaryText(null).toString(),
                            placeAddress = prediction.getSecondaryText(null).toString(),
                            placeOpeningHours = null,
                            placeRating = null,
                            placePhotoReference = null
                        )
                    }
                    continuation.resume(places)
                }
                .addOnFailureListener { exception: Exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }

    private suspend fun fetchPlaceDetails(placeId: String): GooglePlaces {
        val placeFields = listOf(Place.Field.PHOTO_METADATAS, Place.Field.RATING, Place.Field.OPENING_HOURS)
        val request = FetchPlaceRequest.newInstance(placeId, placeFields)

        return suspendCoroutine { continuation ->
            placesClient.fetchPlace(request)
                .addOnSuccessListener { fetchPlaceResponse ->
                    val place = fetchPlaceResponse.place
                    val photoReference = place.photoMetadatas?.firstOrNull()?.zza()
                    val openingHours = place.openingHours?.weekdayText

                    continuation.resume(
                        GooglePlaces(
                            placeId = placeId,
                            placeName = place.name ?: "",
                            placeAddress = place.address ?: "",
                            placeOpeningHours = openingHours,
                            placeRating = place.rating,
                            placePhotoReference = photoReference
                        )
                    )
                }
                .addOnFailureListener { exception: Exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }
}
