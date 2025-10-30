package com.example.gamerzone.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gamerzone.R
import com.example.gamerzone.models.RegistroModel

class RegistroViewModel: ViewModel() {
    val navegacion: Any
    var RegistroViewModel by mutableStateOf(RegistroModel( "","", "", "", 0))

    fun cambiarNombre (nuevoNombre:String){
        RegistroViewModel= RegistroViewModel.copy(nombre = nuevoNombre)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()


        }
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

    fun registro(){
        Log.d("NOMBRE", RegistroViewModel.nombre)
        Log.d("CORREO",RegistroViewModel.correo)
        Log.d("CONTRASEÑA",RegistroViewModel.contrasena)
        Log.d("CONFIRMAR CONTRASEÑA", RegistroViewModel.confirmarContrasena)
        Log.d("TELEFONO", RegistroViewModel.telefono.toString())

        if(RegistroViewModel.nombre.isEmpty()){
                tituloAlerta = "Error de validación"
                mensajeAlerta = "El nombre no puede estar vacío."
                textoBtnAlerta = "Aceptar"
            }else if(!RegistroViewModel.nombre.matches(Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"))){
                tituloAlerta = "Error de validación"
                mensajeAlerta = "El nombre tiene símbolos no permitidos."
                textoBtnAlerta = "Aceptar"
        }else if(RegistroViewModel.nombre.length > 100) {
                tituloAlerta = "Error de validación"
                mensajeAlerta = "El nombre es muy largo."
                textoBtnAlerta = "Aceptar"
        }else if(RegistroViewModel.correo.isBlank() || RegistroViewModel.contrasena.isBlank()) {
            tituloAlerta = "Error de validación"
            mensajeAlerta = "El correo y la contraseña no pueden estar vacíos."
            textoBtnAlerta = "Aceptar"
        }

        } || nombre.lengtRegistroViewModel.contrasena == "1"){
            navegacion = true



        }else{
            tituloAlerta = "Error de credenciales"
            mensajeAlerta = "El correo o la contraseña no corresponden."
            textoBtnAlerta = "Aceptar"
            mostrarAlerta = true
        }
    }


    when {
        nombre.isEmpty() -> {
            etNombre.error = "El campo no puede estar vacío"
        }
         -> {
            etNombre.error = "Solo se permiten letras y espacios"
        }
        nombre.length > 100 -> {
            etNombre.error = "El nombre no puede tener más de 100 caracteres"
        }
        else -> {
            // Pasa la validación
            Toast.makeText(this, "Campo válido", Toast.LENGTH_SHORT).show()
        }
    }

    fun registro({

    })


    fun registro (){
        Log.d("CORREO", loginViewModel.correo)
    }
}