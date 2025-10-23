package com.example.gamerzone.storage

import kotlinx.coroutines.flow.Flow
class JuegosRepository (private val productDao: ProductDao){
    suspend fun insertProduct(product: Producto): Long {
        return productDao.insertProduct(product)
    }
    /

    fun getAllProducts(): Flow<List<Producto>> {
        return productDao.getAllProducts()
    }
}
