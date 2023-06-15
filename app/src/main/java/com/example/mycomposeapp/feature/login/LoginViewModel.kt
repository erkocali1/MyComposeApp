package com.example.mycomposeapp.feature.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel() {
    private val _uiState:MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    val uiState=_uiState
}

    data class LoginUiState(
        val loading:Boolean=false,
        val email:String="",
        val password:String=""
    )
