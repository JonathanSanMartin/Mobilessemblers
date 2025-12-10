package com.example.gamerzone.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamerzone.viewModel.JuegosViewModel

class AgregarJuegoScreen(
    private val navController: NavHostController? = null,
    viewModel: JuegosViewModel,
) {

    @Composable
    fun agregarJuego() {
        val juegosViewModel = viewModel<JuegosViewModel>()

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp, bottom = 30.dp, start = 20.dp, end = 20.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Agregar juego", fontSize = 40.sp)
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = juegosViewModel.state.nombre,
                onValueChange = { juegosViewModel.cambiarNombre(it) },
                label = { Text("Nombre del juego") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = juegosViewModel.state.precio.toString(),
                onValueChange = { juegosViewModel.cambiarPrecio(it.toDoubleOrNull() ?: 0.0) },
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = juegosViewModel.state.imagen.toString(),
                onValueChange = { juegosViewModel.cambiarImagen(it) },
                label = { Text("Imagen") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    juegosViewModel.agregarJuego()
                    navController?.navigate("inicio") // Volver al inicio
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Agregar Juego")
            }
        }
    }
}
