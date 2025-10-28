package com.example.gamerzone.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "juegos")
data class Juegos(
    @PrimaryKey(autoGenerate = true) val id: String = "aa",
    val name: String,
    val price: Double
){}