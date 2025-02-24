package com.example.fakeapi.data


import com.example.fakeapi.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository {
    private val apiService = RetrofitInstance.api

    suspend fun fetchProducts(): List<Product>? {
        return withContext(Dispatchers.IO) {
            val response = apiService.getProducts()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }
}
