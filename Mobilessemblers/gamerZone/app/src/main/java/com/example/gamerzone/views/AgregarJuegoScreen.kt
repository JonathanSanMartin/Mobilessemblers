package com.example.gamerzone.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamerzone.viewModel.JuegosViewModel
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.imePadding

class AgregarJuegoScreen(private val navController: NavHostController? = null) {

    @Composable
    fun agregarJuego() {
        val juegosViewModel = viewModel<JuegosViewModel>()

        val nombre = juegosViewModel.state.nombre
        val precio = juegosViewModel.state.precio
        val imagen = juegosViewModel.state.imagen

        Scaffold(
            modifier = Modifier.imePadding() // ajusta la vista cuando aparece el teclado
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp, bottom = 30.dp, start = 20.dp, end = 20.dp)
                    .verticalScroll(rememberScrollState()) // permite scroll cuando el teclado cubre campos
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Top
            ) {
                Text(text = "Agregar juego", fontSize = 40.sp)
                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { juegosViewModel.cambiarNombre(it) },
                    label = { Text("Nombre del juego") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = precio.toString(),
                    onValueChange = { juegosViewModel.cambiarPrecio(it.toDoubleOrNull() ?: 0.0) },
                    label = { Text("Precio") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = imagen.toString(),
                    onValueChange = { juegosViewModel.cambiarImagen(it.toIntOrNull() ?: 0) },
                    label = { Text("Imagen") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = {
                        juegosViewModel.cambiarNombre(nombre)
                        juegosViewModel.cambiarPrecio(precio)
                        juegosViewModel.cambiarImagen(imagen)
                        juegosViewModel.agregarJuego()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Agregar Juego")
                }
            }
        }
    }
}
