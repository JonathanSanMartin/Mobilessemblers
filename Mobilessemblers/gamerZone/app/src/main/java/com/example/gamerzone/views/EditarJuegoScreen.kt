package com.example.gamerzone.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamerzone.models.Juegos
import com.example.gamerzone.viewModel.JuegosViewModel

class EditarJuegosScreen(private val navHostController: NavHostController? = null,
                               private val id:Int) {

    @Composable
    fun editarVehiculo() {
        val JuegosViewModel = viewModel<JuegosViewModel>()
        val id = this.id

        val nombre = JuegosViewModel.state.nombre
        val precio = JuegosViewModel.state.precio
        val imagen = JuegosViewModel.state.imagen

        LaunchedEffect(id) {
            JuegosViewModel.buscarJuego(id)
        }
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(top = 45.dp, bottom = 30.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Top
        )

        {
            Text(text = "Editar juego " + id, fontSize = 40.sp)
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { JuegosViewModel.cambiarNombre(it) },
                label = { Text("Nombre:") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = precio,
                onValueChange = { JuegosViewModel.cambiarPrecio(0.0) },
                label = { Text("Precio:") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = imagen,
                onValueChange = { JuegosViewModel.cambiarImagen(0) },
                label = { Text("Imagen:") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    val JuegoActualizado = Juegos(
                        id = id,
                        nombre = JuegosViewModel.state.nombre,
                        precio = JuegosViewModel.state.precio,
                        imagen = JuegosViewModel.state.imagen
                    )
                    JuegosViewModel.actualizarJuego(JuegoActualizado)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Editar juego")
            }
        }
    }
}