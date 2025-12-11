package com.example.gamerzone

import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.gamerzone.views.AgregarJuegoScreen
import org.junit.Rule
import org.junit.Test

class PruebaAgregarJuego {
    @get:Rule

    val composableRule = createComposeRule()

    @Test
    fun probarAgregarJuegoApi() {

        composableRule.setContent {
            AgregarJuegoScreen().agregarJuego()
        }
        composableRule.onNodeWithText("Nombre").performTextInput("Testing")
        composableRule.onNodeWithText("Precio").performTextInput("Testing")
        composableRule.onNodeWithText("Imagen").performTextInput("Testing")

        composableRule.onNode(hasText("Agregar juego") and hasClickAction()).assertExists()
            .performClick()
    }
}