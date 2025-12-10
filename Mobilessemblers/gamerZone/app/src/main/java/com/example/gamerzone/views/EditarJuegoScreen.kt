package com.example.gamerzone.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamerzone.models.Juegos
import com.example.gamerzone.viewModel.JuegosViewModel

class EditarJuegoScreen(private val navHostController: NavHostController? = null, private val id: Int) {

    @Composable
    fun editarJuego() {
        val juegosViewModel = viewModel<JuegosViewModel>()
        val id = id

        val nombre = juegosViewModel.state.nombre
        val precio = juegosViewModel.state.precio.toString()
        val imagen = juegosViewModel.state.imagen.toString()

        // Cargar datos del juego
        LaunchedEffect(id) {
            juegosViewModel.buscarJuego(id)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top
        ) {

            Text(text = "Editar juego $id", fontSize = 40.sp)
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { juegosViewModel.cambiarNombre(it) },
                label = { Text("Nombre:") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = precio,
                onValueChange = {
                    juegosViewModel.cambiarPrecio(it.toDoubleOrNull() ?: 0.0)
                },
                label = { Text("Precio:") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = imagen,
                onValueChange = {
                    juegosViewModel.cambiarImagen(it.toIntOrNull() ?: 0)
                },
                label = { Text("Imagen:") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    val juegoActualizado = Juegos(
                        id = id,
                        nombre = juegosViewModel.state.nombre,
                        precio = juegosViewModel.state.precio,
                        imagen = juegosViewModel.state.imagen
                    )
                    juegosViewModel.actualizarJuego(juegoActualizado)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Editar juego")
            }
        }
    }
}
