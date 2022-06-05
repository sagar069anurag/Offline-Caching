package com.example.offlinecaching.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.offlinecaching.data.Restaurant
import com.example.offlinecaching.data.RestaurantDao

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}