package com.example.gamerzone.models

import com.squareup.moshi.Json

data class Juegos(
    @field:Json("id")
    val id: Int,

    @field:Json("nombre")
    val nombre: String,

    @field:Json("precio")
    val precio: Double,

    @field:Json("imagen")
    val imagen: String,
)

data class JuegosState(
    val juegos: List<Juegos> = emptyList(),
    val id: Int? = null,
    val nombre:String = "",
    val precio:Double = 0.0,
    val imagen:String = ""
)

data class JuegosAgregar (
    @field:Json("nombre")
    val nombre: String,

    @field:Json("precio")
    val precio: Double,

    @field:Json("imagen")
    val imagen: String
)