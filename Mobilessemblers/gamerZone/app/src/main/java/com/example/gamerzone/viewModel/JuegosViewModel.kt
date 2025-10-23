package com.example.gamerzone.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamerzone.storage.JuegosRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class JuegosViewModel(private val repository: JuegosRepository) : ViewModel() {

    private val _id = MutableStateFlow("")
    val id: StateFlow<String> = _id

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _price = MutableStateFlow("")
    val price: StateFlow<String> = _price

    //lista de productoss
    val productList = repository.getAllProducts()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun onIdChange(newId: String) {
        _id.value = newId
    }

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onPriceChange(newPrice: String) {
        _price.value = newPrice
    }

    fun saveProduct() {
        val priceDouble = price.value.toDoubleOrNull() ?: 0.0
        val product = Juegos(
            nombre = name.value,
            precio = priceDouble
        )
        viewModelScope.launch {
            repository.insertProduct(product)

            _price.value = ""
            _name.value = ""
        }
    }
}

private fun JuegosRepository.getAllProducts() {
    TODO("Not yet implemented")
}
