package com.example.mycomposeapp.feature.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeapp.core.common.Resource
import com.example.mycomposeapp.core.common.asReSource
import com.example.mycomposeapp.core.data.model.ProductResponse
import com.example.mycomposeapp.domain.usecase.product.GetProductDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState: MutableStateFlow<ProductDetailUiState> =
        MutableStateFlow(ProductDetailUiState())
    val uiState = _uiState

    init {
        val id = savedStateHandle.get<Int>("productId")

        id?.let {
            getProductDetail(it)
        }
    }

    private fun getProductDetail(id: Int) {
        viewModelScope.launch {
            getProductDetailUseCase(id)
                .asReSource()
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _uiState.value = _uiState.value.copy(loading = true)
                        }

                        is Resource.Error -> {
                            _uiState.value = _uiState.value.copy(loading = false)
                        }

                        is Resource.Success -> {
                            _uiState.value =
                                _uiState.value.copy(loading = false, product = result.data)
                        }
                    }
                }.launchIn(this)
        }
    }
}

data class ProductDetailUiState(
    val loading: Boolean = false,
    val product: ProductResponse? = null,
)