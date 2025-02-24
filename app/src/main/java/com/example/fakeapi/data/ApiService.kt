package com.example.fakeapi.data

import com.example.fakeapi.model.Product
import retrofit2.http.GET
import retrofit2.Response

interface ApiService {
    @GET("products") // Endpoint to fetch products
    suspend fun getProducts(): Response<List<Product>>
}