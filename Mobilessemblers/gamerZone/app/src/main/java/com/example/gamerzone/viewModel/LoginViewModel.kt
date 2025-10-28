package com.example.gamerzone.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gamerzone.models.LoginModel

class LoginViewModel: ViewModel() {

    var loginViewModel by mutableStateOf(LoginModel( "",""))

    fun cambiarCorreo(nuevoCorreo:String){
        loginViewModel = loginViewModel.copy(correo = nuevoCorreo)
    }

    fun cambiarContrasena(nuevaContrasena:String){
        loginViewModel = loginViewModel.copy(contrasena = nuevaContrasena)
    }

    var mostrarAlerta by mutableStateOf(false)
        private set
    var tituloAlerta by mutableStateOf("")
        private set
    var mensajeAlerta by mutableStateOf("")
        private set
    var textoBtnAlerta by mutableStateOf("")
        private set

    fun descartarAlerta(){
        mostrarAlerta = false
    }

    var navegacion by mutableStateOf(false)
        private set

    fun cambiarEstadoNavegacion(){
        navegacion = false
    }

    var mostrarConfirmacion by mutableStateOf(false)
        private set
    var tituloConfirmacion by mutableStateOf("")
        private set
    var mensajeConfirmacion by mutableStateOf("")
        private set
    var textoBtnConfirmacion by mutableStateOf("")
        private set
    var textoBtnCancelar by mutableStateOf("")
        private set

    fun btnAceptarConfirmar(){
        mostrarConfirmacion = false
    }

    fun btnCancelarConfirmar(){
        mostrarConfirmacion = false
    }

    fun terminarConfirmar(){
        mostrarConfirmacion = false
    }

    fun auth(){
        Log.d("CORREO",loginViewModel.correo)
        Log.d("CONTRASEÑA",loginViewModel.contrasena)

        if(loginViewModel.correo == "1" && loginViewModel.contrasena == "1"){
            navegacion = true

        }else if(loginViewModel.correo.isBlank() || loginViewModel.contrasena.isBlank()){
            tituloAlerta = "Error de validación"
            mensajeAlerta = "El correo y la contraseña no pueden estar vacíos."
            textoBtnAlerta = "Aceptar"

        }else{
            tituloAlerta = "Error de credenciales"
            mensajeAlerta = "El correo o la contraseña no corresponden."
            textoBtnAlerta = "Aceptar"
            mostrarAlerta = true
        }
    }
}