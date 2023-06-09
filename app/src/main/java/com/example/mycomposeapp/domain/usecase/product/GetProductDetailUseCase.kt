package com.example.mycomposeapp.domain.usecase.product

import com.example.mycomposeapp.core.data.model.ProductResponse
import com.example.mycomposeapp.core.data.remote.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetProductDetailUseCase @Inject constructor(private val productRepository: ProductRepository) {
    operator fun invoke(id: Int): Flow<ProductResponse> {
        return flow {
            val result = productRepository.getProductDetail(id)
            (result.getOrNull() ?: throw IllegalArgumentException("error message")).also {
                emit(it)
            }
        }
    }
}