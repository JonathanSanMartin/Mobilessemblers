package com.example.gamerzone.storage

import kotlinx.coroutines.flow.Flow
class JuegosRepository (private val juegosDao: JuegosDao){
    suspend fun insertProduct(product: com.example.gamerzone.models.Juegos): String {
        return ("test")
    }

    fun getAllProducts(): Flow<List<Juegos>> {
        return juegosDao.getAllProducts()
    }
}

private fun JuegosDao.Companion.insertProduct(juegos: Juegos): String {
return ("test") }

