package com.example.mycomposeapp.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun LoginScreenRoute(
    modifier: Modifier = Modifier, viewModel: LoginViewModel = hiltViewModel()
) {
    val loginUiState by viewModel.uiState.collectAsStateWithLifecycle()
    LoginScreen(modifier = modifier, loginUiState = loginUiState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier, loginUiState: LoginUiState
) {
    Scaffold {
        Content(modifier = modifier.padding(it), loginUiState = loginUiState)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content(modifier: Modifier = Modifier, loginUiState: LoginUiState) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login Screen")
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email"
                )
            },

            value = loginUiState.email,
            onValueChange = {}
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            label = {
                Text(text = "Password")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Email"
                )
            },

            value = loginUiState.email,
            onValueChange = {})
    }


}