package com.example.gamerzone.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamerzone.viewModel.JuegosViewModel
import com.example.gamerzone.views.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // LOGIN
        composable("login") {
            LoginScreen(navController).login()
        }

        // INICIO (pantalla principal de juegos)
        composable("inicio") {
            val juegosViewModel: JuegosViewModel = viewModel()
            InicioScreen(navController = navController, viewModel = juegosViewModel)
        }

        // JUEGOS (otra pantalla para mostrar lista de juegos)
        composable("juegos") {
            val juegosViewModel: JuegosViewModel = viewModel()
            InicioScreen(navController = navController, viewModel = juegosViewModel)
        }

        // AGREGAR JUEGO
        composable("agregarJuego") {
            val JuegosViewModel: JuegosViewModel = viewModel()
            AgregarJuegoScreen(navController, viewModel = JuegosViewModel).agregarJuego()
        }

        // EDITAR JUEGO
        composable("editarJuego/{id}") { backStackEntry ->
            val idString = backStackEntry.arguments?.getString("id")
            val id = idString?.toIntOrNull() ?: 0
            val JuegosViewModel: JuegosViewModel = viewModel()
            EditarJuegoScreen(navController, viewModel = JuegosViewModel, id = id).editarJuego()
        }

        // REGISTRO
        composable("registro") {
            RegistroScreen(navController).registro()
        }

        // CÁMARA
        composable("camara") {
            CamaraScreen(navController).camara()
        }

        // VIBRACIÓN
        composable("vibrar") {
            VibracionScreen(navController).vibracion()
        }
    }
}