package com.example.gamerzone.repository

import okhttp3.OkHttpClient
import com.example.gamerzone.models.Juegos
import com.example.gamerzone.models.JuegosAgregar
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface JuegosService {

    companion object {
        val instance =
            Retrofit.Builder().baseUrl("https://6939f53fc8d59937aa0970ec.mockapi.io/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build().create(JuegosService::class.java)
    }

    @GET("juegos")
    suspend fun obtenerJuego(): List<Juegos>

    @GET("juegos/{id}")
    suspend fun buscarJuego(@Path("id") id: Int): Juegos

    @POST("juegos")
    suspend fun agregarJuego(@Body juego: JuegosAgregar)

    @PUT("juegos/{id}")
    suspend fun actualizarJuego(@Body juego: Juegos)

    @DELETE("juegos/{id}")
    suspend fun eliminarJuego(@Path("id") id: Int)
}


