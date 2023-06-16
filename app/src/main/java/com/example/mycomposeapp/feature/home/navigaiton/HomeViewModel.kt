package com.example.mycomposeapp.feature.home.navigaiton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeapp.core.common.Resource
import com.example.mycomposeapp.core.common.asReSource
import com.example.mycomposeapp.core.data.model.ProductResponse
import com.example.mycomposeapp.domain.usecase.product.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState = _uiState

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            productsUseCase().asReSource().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(loading = true)
                    }

                    is Resource.Error -> {
                        _uiState.value = _uiState.value.copy(loading = false)
                    }

                    is Resource.Success -> {
                        _uiState.value =
                            _uiState.value.copy(loading = false, products = result.data)
                    }
                }
            }.launchIn(this)
        }
    }
}


data class HomeUiState(
    val loading: Boolean = false,
    val products: List<ProductResponse> = listOf(),
)