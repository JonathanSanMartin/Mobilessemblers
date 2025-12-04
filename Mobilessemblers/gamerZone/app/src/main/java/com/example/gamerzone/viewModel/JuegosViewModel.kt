package com.example.gamerzone.viewModel

import android.R.attr.id
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamerzone.models.Juegos
import com.example.gamerzone.models.JuegosAgregar
import com.example.gamerzone.models.JuegosState
import kotlinx.coroutines.launch

class JuegosViewModel : ViewModel() {

    private val JuegosService = JuegosService.instance

    var state by mutableStateOf(JuegosState())

    init {
        obtenerJuegos()
    }

    fun cambiarNombre(nuevoNombre: String) {
        state = state.copy(nombre = nuevoNombre)
    }

    fun cambiarPrecio(nuevoPrecio: Double) {
        state = state.copy(precio = nuevoPrecio)
    }

    fun cambiarImagen(nuevaImagen: Int) {
        state = state.copy(imagen = nuevaImagen)
    }

    fun cambiarId(nuevaId: Int) {
        state = state.copy(id = nuevaId)
    }

    fun obtenerJuegos() {
        viewModelScope.launch {
            try {
                val juegosObtenidos = JuegosService.obtenerJuegos()
                state = state.copy(juegos = juegosObtenidos)
            } catch (e: Exception) {
            }
        }
    }

    private fun JuegosState.copy(
        nombre: String,
        precio: String,
        imagen: String
    ): JuegosState {
        return TODO("Provide the return value")
    }

    fun agregarJuego() {
        viewModelScope.launch {
            try {
                // val imagen = state.imagen.toIntOrNull() ?: 0

                val nuevoJuego = JuegosAgregar(
                    nombre = state.nombre,
                    precio = state.precio,
                    imagen = state.imagen
                )

                JuegosService.agregarJuegos(nuevoJuego)
                state = state.copy(
                    nombre = "",
                    precio = 0.0,
                    imagen = 0
                )
            } catch (e: Exception) {
            }
        }
    }

    fun buscarJuego(id: Int){
        viewModelScope.launch {
            try {
                val juegoEncontrado = JuegosService.buscarJuego(id)
                cambiarNombre(juegoEncontrado.nombre)
                cambiarPrecio(juegoEncontrado.precio)
                cambiarId(juegoEncontrado.id)
            }catch (e: Exception){
            }
        }
    }

    fun actualizarJuego (juegos: Juegos){
        state = state.copy(
            nombre = juegos.nombre,
            precio = juegos.precio,
            imagen = juegos.imagen
        )
        viewModelScope.launch {
            try {
                JuegosService.actualizarJuego(juegos)
            }catch (e: Exception){
            }
        }
    }

    fun eliminarJuego (id:Int){
        viewModelScope.launch {
            try{
                if (id != null){
                    JuegosService.eliminarJuego(id)
                }
                obtenerJuegos()
            }catch (e: Exception){

            }
        }
    }
}
