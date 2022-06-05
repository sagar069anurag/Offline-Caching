package com.example.offlinecaching.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.offlinecaching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()
}