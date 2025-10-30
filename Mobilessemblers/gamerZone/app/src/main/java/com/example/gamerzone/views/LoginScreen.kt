package com.example.gamerzone.views

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamerzone.R
import com.example.gamerzone.helper.showAlert
import com.example.gamerzone.helper.showConfirm
import com.example.gamerzone.viewModel.LoginViewModel

class LoginScreen(private val navController: NavHostController? = null) {

    @Composable
    fun login(){

        val viewModel = viewModel<LoginViewModel>()
        val correo = viewModel.loginViewModel.correo
        val contrasena = viewModel.loginViewModel.contrasena

        val nav = viewModel.navegacion

        if(nav == true){
            navController?.navigate("inicio")
            viewModel.cambiarEstadoNavegacion()
        }


        if(viewModel.mostrarAlerta == true){
            showAlert(
                titulo = viewModel.tituloAlerta,
                mensaje = viewModel.mensajeAlerta,
                onDismiss = {viewModel.descartarAlerta()},
                onConfirm = {viewModel.descartarAlerta()},
                textoBtnConfirmar = viewModel.textoBtnCancelar
            )
        }

        if(viewModel.mostrarConfirmacion == true){
            showConfirm(
                titulo = viewModel.tituloConfirmacion,
                mensaje = viewModel.mensajeConfirmacion,
                textoBtnCancelar = viewModel.textoBtnCancelar,
                textoBtnConfirmar = viewModel.textoBtnConfirmacion,
                eventoCancelar = {viewModel.btnCancelarConfirmar()},
                eventoConfirmar = {viewModel.btnAceptarConfirmar()},
                eventoTerminarAlerta = {viewModel.terminarConfirmar()}
            )
        }


        val trancisionInfinita = rememberInfiniteTransition()

        val offsetY by trancisionInfinita.animateFloat(
            initialValue = 0f,
            targetValue = 20f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )

        var cambioColor by remember{ mutableStateOf(false) }

        val colorFondo by animateColorAsState(
            if(cambioColor) Color.Red else Color.Blue
        )


        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(colorFondo)
                .clickable{cambioColor = !cambioColor}
                .padding(32.dp),
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Iniciar sesión",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth()
                    .offset(y = offsetY.dp),
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.imagenlogin),
                contentDescription = "imagenLogin",
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = offsetY.dp)
            )

            Spacer(modifier = Modifier.height(35.dp))

            TextField(
                value = correo,
                onValueChange = {viewModel.cambiarCorreo(it)},
                label = {Text("Correo electrónico")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = contrasena,
                onValueChange = {viewModel.cambiarContrasena(it)},
                label = {Text("Contraseña")},
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {viewModel.auth()},
                modifier = Modifier.fillMaxWidth()
            )
            {
                Text("Acceder")
            }

            Button(
                onClick = {viewModel.registro()},
                modifier = Modifier.fillMaxWidth()
            )
            {
                Text("Registrarse")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun verLogin(){
    LoginScreen().login()
}