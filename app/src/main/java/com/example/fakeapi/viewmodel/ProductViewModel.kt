package com.example.fakeapi.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakeapi.data.ProductRepository
import com.example.fakeapi.model.Product
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ProductViewModel : ViewModel() {
    private val repository = ProductRepository()

    private val _products = MutableStateFlow<List<Product>?>(null)
    val products: StateFlow<List<Product>?> = _products

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _products.value = repository.fetchProducts()
        }
    }
}
