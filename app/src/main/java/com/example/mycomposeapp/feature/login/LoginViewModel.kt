package com.example.mycomposeapp.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeapp.core.common.Resource
import com.example.mycomposeapp.core.common.asReSource
import com.example.mycomposeapp.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    val uiState = _uiState

    fun onEmailChange(email: String) {
        uiState.value = _uiState.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        uiState.value = _uiState.value.copy(password = password)
    }

    fun onLogin() {
        viewModelScope.launch {
            loginUseCase(_uiState.value.email, _uiState.value.password).asReSource()
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _uiState.value = _uiState.value.copy(loading = true)
                        }

                        is Resource.Error -> {
                            _uiState.value = _uiState.value.copy(loading = false)
                        }

                        is Resource.Success -> {
                            _uiState.value = _uiState.value.copy(loading = false)
                        }

                    }
                }
        }
    }
}

data class LoginUiState(
    val loading: Boolean = false, val email: String = "", val password: String = ""
)
