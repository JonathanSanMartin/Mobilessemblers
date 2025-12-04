package com.example.gamerzone.repository

import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.Path
import okhttp3.OkHttpClient
import com.example.gamerzone.models.Juegos
import com.example.gamerzone.models.JuegosAgregar
/* import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
 */

interface JuegosService {

    companion object {
        val instance =
            Retrofit.Builder().baseUrl("")
                .addConverterFactory(MoshiConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build().create(JuegosService::class.java)
    }

    @GET("juegos")
    suspend fun obtenerJuego(): List<Juegos> {
    }

    @GET("juegos/{id}")
    suspend fun buscarJuego(@Path("id") id: Int): List<Juegos> {
    }

    @POST("juegos")
    suspend fun agregarJuego(@Body auto: JuegosAgregar)

    @PUT("juegos")
    suspend fun actualizarJuego(@Body auto: Juegos)

    @DELETE("juegos/{id}")
    suspend fun eliminarJuego(@Path("id") id: Int)
}


