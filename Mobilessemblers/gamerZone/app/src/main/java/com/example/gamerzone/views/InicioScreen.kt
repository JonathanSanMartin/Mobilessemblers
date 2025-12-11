package com.example.gamerzone.views

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.gamerzone.models.Juegos
import com.example.gamerzone.viewModel.JuegosViewModel
import coil.compose.rememberAsyncImagePainter

class InicioScreen (
    private val navController: NavHostController? = null,
    private val viewModel: JuegosViewModel
)

@Composable
fun InicioScreen(
    navController: NavHostController,
    viewModel: JuegosViewModel = viewModel()
) {
    var expandirMenu by remember { mutableStateOf(false) }
    var menuDerecha by remember { mutableStateOf(false) }

    val state = viewModel.state
    val juegos = state.juegos

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inicio") },
                navigationIcon = {
                    IconButton(onClick = { expandirMenu = true }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                    DropdownMenu(
                        expanded = expandirMenu,
                        onDismissRequest = { expandirMenu = false }
                    ) {
                        DropdownMenuItem(onClick = { navController.navigate("juegos") }) {
                            Text("Ver juegos")
                        }
                        DropdownMenuItem(onClick = { navController.navigate("agregarJuego") }) {
                            Text("Agregar juego")
                        }

                        DropdownMenuItem(onClick = { navController?.navigate("camara")
                            expandirMenu = false }) {
                            Text(text = "Abrir cámara")
                        }
                        DropdownMenuItem(onClick = { navController?.navigate("vibrar")
                            expandirMenu = false }) {
                            Text(text = "Probar vibración")
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { menuDerecha = true }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "Menú derecha")
                    }
                    DropdownMenu(
                        expanded = menuDerecha,
                        onDismissRequest = { menuDerecha = false }
                    ) {
                        DropdownMenuItem(onClick = {
                            Log.d("TAAAAG", "AZUL")
                            Log.i("TAAAAG", "VERDE")
                            Log.v("TAAAAG", "BLANCO")
                            Log.e("TAAAAG", "ROJO")
                        }) {
                            DropdownMenuItem(onClick = { navController.navigate("login") }) {
                                Text("Cerrar sesión")
                            }
                        }
                    }
                },
                    modifier = Modifier.systemBarsPadding()
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            Text(
                text = "Bienvenido a GamerZone",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // LISTADO VISUAL DE JUEGOS
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Listado de juegos",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))
                // LISTADO DE JUEGOS
                juegos.forEach { juego ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        elevation = 4.dp
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(juego.imagen),
                                    contentDescription = "Imagen Juego",
                                    modifier = Modifier.size(60.dp)
                                )

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(text = "Nombre: ${juego.nombre}")
                                    Text(text = "Precio: ${juego.precio}")
                                }

                                Button(
                                    onClick = { navController.navigate("editarJuego/${juego.id}") }
                                ) {
                                    Text("Editar")
                                }
                            }

                            Divider()
                        }
                    }
                }
                BackHandler {  }
                Spacer(Modifier.height(20.dp))

                // INPUTS PARA AGREGAR
                OutlinedTextField(
                    value = state.nombre,
                    onValueChange = { viewModel.cambiarNombre(it) },
                    label = { Text("Nombre del juego") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(8.dp))

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

                Button(
                    onClick = { viewModel.agregarJuego() },
                    enabled = state.nombre.isNotBlank() && state.precio > 0,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Guardar juego")
                }
                Divider()
            }
        }
    }
}

/*
*/