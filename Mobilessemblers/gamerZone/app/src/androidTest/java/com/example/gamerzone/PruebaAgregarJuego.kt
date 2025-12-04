package com.example.gamerzone

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.gamerzone.views.AgregarJuegoScreen
import org.junit.Rule

class PruebaAgregarJuego {
    @get:Rule

    val composableRule = createComposeRule()

    @Test
    fun probarAgregarJuegoApi(){

        composableRule.setContent {
            AgregarJuegoScreen().agregarJuego()
        }
    }
}