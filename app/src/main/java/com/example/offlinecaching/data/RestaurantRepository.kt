package com.example.offlinecaching.data

import androidx.room.withTransaction
import com.example.offlinecaching.api.RestaurantApi
import com.codinginflow.simplecachingexample.util.networkBoundResource
import com.example.offlinecaching.data.RestaurantDatabase
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
) {
    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            api.getRestaurants()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }
        }
    )
}