package com.example.gamerzone.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamerzone.models.Juegos
import com.example.gamerzone.models.JuegosAgregar
import com.example.gamerzone.models.JuegosState
import com.example.gamerzone.repository.JuegosService
import kotlinx.coroutines.launch

class JuegosViewModel : ViewModel() {
    private val service: JuegosService = JuegosService.instance
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

    fun cambiarImagen(nuevaImagen: String) {
        state = state.copy(imagen = nuevaImagen)
    }

    fun obtenerJuegos() {
        viewModelScope.launch {
            try {
                val juegosObtenidos = service.obtenerJuego()
                state = state.copy(juegos = juegosObtenidos)
            } catch (e: Exception) { }
        }
    }

    fun buscarJuego(id: Int){
        viewModelScope.launch {
            try {
                val juegoEncontrado = service.buscarJuego(id)
                cambiarNombre(juegoEncontrado.nombre)
                cambiarPrecio(juegoEncontrado.precio)
            }catch (e: Exception){
            }
        }
    }
    fun agregarJuego() {
        viewModelScope.launch {
            try {
                val nuevoJuego = JuegosAgregar(
                    nombre = state.nombre,
                    precio = state.precio,
                    imagen = state.imagen
                )
                service.agregarJuego(nuevoJuego)
                state = state.copy(nombre = "", precio = 0.0, imagen = "")
                obtenerJuegos()
            } catch (e: Exception) { }
        }
    }

    fun actualizarJuego(juego: Juegos) {
        viewModelScope.launch {
            try {
                service.actualizarJuego(juego)
                obtenerJuegos()
            } catch (e: Exception) { }
        }
    }

    fun eliminarJuego(id: Int) {
        viewModelScope.launch {
            try {
                service.eliminarJuego(id)
                obtenerJuegos()
            } catch (e: Exception) { }
        }
    }
}
