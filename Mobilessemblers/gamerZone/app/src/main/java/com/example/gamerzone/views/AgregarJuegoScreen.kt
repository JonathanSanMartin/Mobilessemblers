package com.example.gamerzone.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamerzone.viewModel.JuegosViewModel

class AgregarJuegoScreen (private val navController: NavHostController? = null){
    @Composable

    fun agregarJuego (){
        val juegosViewModel = viewModel<JuegosViewModel>()

        val nombre = juegosViewModel.state.nombre
        val precio = juegosViewModel.state.modelo
        val imagen = juegosViewModel.state.imagen

        Column (modifier = Modifier.fillMaxSize().padding(top = 40.dp, bottom = 30.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Top
        ){
            Text(text = "Agregar juego", fontSize = 40.sp)
            Spacer (Modifier.height(16.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = {juegosViewModel.cambiarNombre(it)},
                label = {Text("Nombre del juego")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = precio,
                onValueChange = {juegosViewModel.cambiarPrecio(it)},
                label = {Text("Precio")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = imagen,
                onValueChange = {juegosViewModel.cambiarImagen(it)},
                label = {Text("Imagen")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
        }

        Button(
            onClick = {juegosViewModel.agregarJuego()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Juego")
        }
    }
}

@Preview(showBackground = true)
@Composable

fun verAgregar (){
    AgregarJuegoScreen().agregarJuego()
}