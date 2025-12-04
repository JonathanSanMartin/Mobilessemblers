package com.example.gamerzone.repository

import androidx.compose.ui.graphics.vector.Path
import com.example.gamerzone.models.Juegos
import okhttp3.OkHttpClient

class JuegosService {

    companion object {
        val instance =
            Retrofit.Builder().baseUrl("")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build().create(JuegosService::class.java)
    }

    @GET("juegos")
    suspend fun obtenerJuegos(): List<Juegos> {
    }

    @GET("juegos/{id}")
    suspend fun buscarJuegos(@Path("id") id: Int): List<Juegos> {
    }

    @POST("juegos")
    suspend fun agregarJuegos(@Body auto: JuegosAgregar)

    @PUT("juegos")
    suspend fun actualizarJuegos(@Body auto: Juegos)

    @DELETE("juegos/{id}")
    suspend fun eliminarJuegos(@Path("id") id: Int)
}

