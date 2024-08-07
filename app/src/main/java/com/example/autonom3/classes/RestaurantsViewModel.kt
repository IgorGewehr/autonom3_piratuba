package com.example.autonom3.classes

import PlacesRepository
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RestaurantsViewModel(private val placesRepository: PlacesRepository) : ViewModel() {

    private val _restaurants = MutableStateFlow<List<GooglePlaces>>(emptyList())
    val restaurants: StateFlow<List<GooglePlaces>> = _restaurants.asStateFlow()

    init {
        fetchRestaurants()
    }

    fun fetchRestaurants() {
        viewModelScope.launch {
            try {
                Log.d("RestaurantsViewModel", "Fetching restaurants")
                _restaurants.value = placesRepository.fetchPlaces("Restaurantes em Piratuba - SC")
                Log.d("RestaurantsViewModel", "Restaurants fetched successfully")
            } catch (e: Exception) {
                Log.e("RestaurantsViewModel", "Error fetching restaurants", e)
            }
        }
    }
}
