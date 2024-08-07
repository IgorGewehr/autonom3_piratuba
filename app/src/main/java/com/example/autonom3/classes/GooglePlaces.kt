package com.example.autonom3.classes

data class GooglePlaces(
    val placeId: String,
    val placeName: String,
    val placeAddress: String,
    val placeOpeningHours: List<String>?,
    val placeRating: Double?,
    val placePhotoReference: String?
)
