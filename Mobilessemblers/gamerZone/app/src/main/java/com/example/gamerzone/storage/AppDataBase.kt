package com.example.gamerzone.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gamerzone.models.Juegos

@Database(entities = [Juegos::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}

annotation class ProductDao
