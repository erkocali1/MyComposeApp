package com.example.mycomposeapp.core.data.remote.api

import com.example.mycomposeapp.core.data.model.ProductResponse
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProducts(): List<ProductResponse>

    @GET("products/{id}")
    suspend fun getProductDetail(id: Int): ProductResponse
}