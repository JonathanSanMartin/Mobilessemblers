package com.example.gamerzone.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamerzone.models.Juegos
import com.example.gamerzone.viewModel.JuegosViewModel


@Composable
fun JuegosScreen(
    navController: NavHostController,
    viewModel: JuegosViewModel = viewModel()
) {
    val juegos by remember { derivedStateOf { viewModel.state.juegos } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Juegos") },
                actions = {
                    Button(onClick = { navController.navigate("inicio") }) {
                        Text("Volver")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(juegos) {juego: Juegos ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = 4.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .padding(end = 12.dp)
                        ) {
                        }

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Nombre: ${juego.nombre}")
                            Text(text = "Precio: ${juego.precio}")
                        }

                        Button(
                            onClick = { navController.navigate("editarJuego/${juego.id}") },
                            modifier = Modifier.padding(start = 12.dp)
                        ) {
                            Text("Editar")
                        }
                    }
                }
            }
        }
    }
}
