package com.example.mycomposeapp.core.data.remote.source


import com.example.mycomposeapp.core.data.model.ProductResponse
import com.example.mycomposeapp.core.data.remote.api.ProductService
import javax.inject.Inject

class ProductRemoteDataImpl @Inject constructor(
    private val productService: ProductService
) : ProductRemoteDataSource {

    override suspend fun getProducts(): Result<List<ProductResponse>> {
        return runCatching {
            productService.getProducts()
        }
    }

    override suspend fun getProductDetail(id: Int): Result<ProductResponse> {
        return runCatching {
            productService.getProductDetail(id)
        }
    }
}