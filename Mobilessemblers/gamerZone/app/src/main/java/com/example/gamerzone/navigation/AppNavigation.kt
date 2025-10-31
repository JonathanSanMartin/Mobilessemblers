package com.example.gamerzone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamerzone.views.CamaraScreen
import com.example.gamerzone.views.InicioScreen
import com.example.gamerzone.views.LoginScreen
import com.example.gamerzone.views.RegistroScreen
import com.example.gamerzone.views.VibracionScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController).login()
        }

        composable("inicio") {
            InicioScreen(navController).inicio()
        }
        composable("camara") {
            CamaraScreen(navController).camara()
        }
        composable("vibracion") {
            VibracionScreen(navController).vibracion()
        }

        composable("registro") {
            RegistroScreen(navController).registro()
        }
    }
}




