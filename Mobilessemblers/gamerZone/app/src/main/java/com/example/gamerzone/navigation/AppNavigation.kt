package com.example.gamerzone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamerzone.views.InicioScreen
import com.example.gamerzone.views.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ){
        composable("login"){
            LoginScreen(navController).login()
        }

        composable("inicio"){
            InicioScreen(navController)
        }

        composable ("camara"){
            // composable("productos") {
            //            ProductoScreen(navController, viewModel).pantallaProducto()
            //        }
            //
            //        composable ("camara"){
            //            CamaraScreen(navController).camara()
            //        }
            //
            //        composable ("vibrar"){
            //            VibracionScreen(navController).BotonVibrar()
            //        }

        }
    }
}

