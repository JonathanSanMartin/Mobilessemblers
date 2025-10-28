package com.example.gamerzone.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JuegosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Juegos): Long

    @Query("SELECT * FROM juegos ORDER BY id DESC")
    fun getAllProducts(): Flow<List<Juegos>>

    companion object
}