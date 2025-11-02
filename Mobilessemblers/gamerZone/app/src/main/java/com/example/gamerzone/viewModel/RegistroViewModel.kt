package com.example.gamerzone.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gamerzone.models.RegistroModel

class RegistroViewModel: ViewModel() {
    var RegistroViewModel by mutableStateOf(RegistroModel("", "", "", "", 0))

    // variables.
    fun cambiarNombre(nombre: String) {
        RegistroViewModel = RegistroViewModel.copy(nombre)
    }

    fun cambiarCorreo(correo: String) {
        RegistroViewModel = RegistroViewModel.copy(correo = correo)
    }

    fun cambiarContrasena(contrasena: String): String? {
        RegistroViewModel = RegistroViewModel.copy(contrasena = contrasena)
        if (!contrasena.any { it.isUpperCase() })
            return "Debe incluir al menos una letra mayúscula"
        if (!contrasena.any { it.isLowerCase() })
            return "Debe incluir al menos una letra minúscula"
        if (!contrasena.any { it.isDigit() })
            return "Debe incluir al menos un número"
        if (!contrasena.any { it in "@#\$%&*!?" })
            return "Debe incluir al menos un carácter especial (@#\$%&*!?)"
        return null
    }

    fun cambiarConfirmarContrasena(confirmarContrasena: String) {
        RegistroViewModel = RegistroViewModel.copy(confirmarContrasena = confirmarContrasena)
    }


    fun cambiarTelefono(telefono: Int) {
        RegistroViewModel = RegistroViewModel.copy(telefono = telefono)
    }

    var mostrarAlerta by mutableStateOf(false)
        private set
    var tituloAlerta by mutableStateOf("")
        private set
    var mensajeAlerta by mutableStateOf("")
        private set
    var textoBtnAlerta by mutableStateOf("")
        private set

    // navegacion
    fun descartarAlerta() {
        mostrarAlerta = false
    }

    var navegacion by mutableStateOf(false)
        private set

    fun cambiarEstadoNavegacion() {
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

    //botones
    fun btnAceptarConfirmar() {
        mostrarConfirmacion = false
    }

    fun btnCancelarConfirmar() {
        mostrarConfirmacion = false
    }

    fun terminarConfirmar() {
        mostrarConfirmacion = false
    }

    //FUNCION DE REGISTRO.
    fun registro() {
        Log.d("NOMBRE", RegistroViewModel.nombre)
        Log.d("CORREO", RegistroViewModel.correo)
        Log.d("CONTRASEÑA", RegistroViewModel.contrasena)
        Log.d("CONFIRMAR CONTRASEÑA", RegistroViewModel.confirmarContrasena)
        Log.d("TELEFONO", RegistroViewModel.telefono.toString())

        if (RegistroViewModel.nombre.isEmpty()) {
            tituloAlerta = "Error de validación"
            mensajeAlerta = "El nombre no puede estar vacío."
            textoBtnAlerta = "Aceptar"
            mostrarAlerta = true
        } else if (!RegistroViewModel.nombre.matches(Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"))) {
            tituloAlerta = "Error de validación"
            mensajeAlerta = "El nombre tiene símbolos no permitidos."
            textoBtnAlerta = "Aceptar"
            mostrarAlerta = true
        } else if (RegistroViewModel.nombre.length > 100) {
            tituloAlerta = "Error de validación"
            mensajeAlerta = "El nombre es muy largo."
            textoBtnAlerta = "Aceptar"
            mostrarAlerta = true
        } else if (RegistroViewModel.correo.isBlank() || RegistroViewModel.contrasena.isBlank()) {
            tituloAlerta = "Error de validación"
            mensajeAlerta = "El correo y la contraseña no pueden estar vcíos."
            textoBtnAlerta = "Aceptar"
            mostrarAlerta = true
        } else if (RegistroViewModel.correo.matches(Regex("^[A-Za-z0-9._%+-]+@duoc\\.cl$")) || RegistroViewModel.correo.length <= 60) {
            tituloAlerta = "Error de validación"
            mensajeAlerta = "El correo debe ser mayor a 60 caracteres y ser duoc.cl"
            textoBtnAlerta = "Aceptar"
            mostrarAlerta = true
        } else if (RegistroViewModel.contrasena !== RegistroViewModel.confirmarContrasena) {
            tituloAlerta = "Error de validación"
            mensajeAlerta = "Las contraseñas no coinciden."
            textoBtnAlerta = "Aceptar"
            mostrarAlerta = true
        }else if (RegistroViewModel.telefono.matches(Regex("^\\d+$"))){
            tituloAlerta = "Error de validación"
            mensajeAlerta = "Solo números en el número de telefono"
            textoBtnAlerta = "Aceptar"
            mostrarAlerta = true
        } else {
            navegacion = true
        }
    }
}

private fun Int.matches(int: kotlin.text.Regex): Boolean {
return true
}

