package com.example.gamerzone.storage

import kotlinx.coroutines.flow.Flow
class JuegosRepository (private val juegosDao: JuegosDao){
    suspend fun insertProduct(product: Juegos): Long {
        return JuegosDao.insertProduct(product)
    }

    fun getAllProducts(): Flow<List<Juegos>> {
        return juegosDao.getAllProducts()
    }
}
