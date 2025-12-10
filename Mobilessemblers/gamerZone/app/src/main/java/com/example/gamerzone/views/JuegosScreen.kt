package com.example.gamerzone.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gamerzone.viewModel.JuegosViewModel

class JuegosScreen(
    private val navController: NavHostController? = null,
    private val viewModel: JuegosViewModel
) {

    @Composable
    fun JuegoScreen() {

        val state = viewModel.state   // usa el estado completo

        Column(
            modifier = Modifier
                .padding(16.dp)
                .systemBarsPadding()
        ) {

            Text(
                text = "Gestionar Juegos",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            // Nombre
            OutlinedTextField(
                value = state.nombre,
                onValueChange = { viewModel.cambiarNombre(it) },
                label = { Text("Nombre del juego") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            // Precio
            OutlinedTextField(
                value = state.precio.toString(),
                onValueChange = {
                    val valor = it.toDoubleOrNull() ?: 0.0
                    viewModel.cambiarPrecio(valor)
                },
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(8.dp))

            // Guardar
            Button(
                onClick = { viewModel.agregarJuego() },
                enabled = state.nombre.isNotBlank() && state.precio > 0,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar juego")
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = "Listado de Juegos",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(Modifier.height(8.dp))

            // Lista de juegos
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(state.juegos) { product ->

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text("ID: ${product.id}", fontWeight = FontWeight.SemiBold)
                        Text("Nombre: ${product.nombre}")
                        Text("Precio: ${product.precio}")
                    }

                    Divider()
                }
            }
        }
    }
}
