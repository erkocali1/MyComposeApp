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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun LoginScreenRoute(
    modifier: Modifier = Modifier, viewModel: LoginViewModel = hiltViewModel()
) {
    val loginUiState by viewModel.uiState.collectAsStateWithLifecycle()
    LoginScreen(
        modifier = modifier,
        loginUiState = loginUiState,
        onEmailChangeValue = viewModel::onEmailChange,
        onPasswordChangeValue = viewModel::onPasswordChange
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier, loginUiState: LoginUiState, onEmailChangeValue: (String) -> Unit,
    onPasswordChangeValue: (String) -> Unit,
) {
    Scaffold {
        Content(
            modifier = modifier.padding(it),
            loginUiState = loginUiState,
            onEmailChangeValue = onEmailChangeValue,
            onPasswordChangeValue = onPasswordChangeValue
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content(
    modifier: Modifier = Modifier, loginUiState: LoginUiState, onEmailChangeValue: (String) -> Unit,
    onPasswordChangeValue: (String) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login Screen")
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(label = {
            Text(text = "Email")
        }, leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email, contentDescription = "Email"
            )
        },

            value = loginUiState.email, onValueChange = onEmailChangeValue
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            label = {
                Text(text = "Password")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock, contentDescription = "Password"
                )
            },

            visualTransformation = PasswordVisualTransformation(),
            value = loginUiState.password,
            onValueChange = onPasswordChangeValue
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Continue With Google")
        }
    }

}