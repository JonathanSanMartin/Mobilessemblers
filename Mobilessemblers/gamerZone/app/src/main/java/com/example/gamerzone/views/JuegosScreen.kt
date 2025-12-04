package com.example.gamerzone.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gamerzone.viewModel.JuegosViewModel

class JuegosScreen (private val navController: NavHostController? = null, private val viewModel: JuegosViewModel) {

    @Composable
    fun pantallaJuegos() {
        val nombre by viewModel.name.collectAsState()
        val precio by viewModel.price.collectAsState()
        val productList by viewModel.productList.collectAsState()

        Column(modifier = Modifier.padding(16.dp).systemBarsPadding()) {

            Text(
                text = "Gestionar juegos",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(32.dp).fillMaxWidth()
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { viewModel.onNameChange(it) },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = precio,
                onValueChange = { viewModel.onPriceChange(it) },
                label = { Text("Precio") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { viewModel.saveProduct() },
                enabled = nombre.isNotBlank() && precio.isNotBlank(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar juego")
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Se guardaron los juegos exitosamente.",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(productList) { product ->
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                    ) {
                        Text(text = "ID: ${product.id}", fontWeight = FontWeight.SemiBold)
                        Text(text = "Nombre del juego: ${product.name}")
                        Text(text = "Precio: ${product.price}")
                    }
                    Divider()
                }
            }
        }
    }
}
