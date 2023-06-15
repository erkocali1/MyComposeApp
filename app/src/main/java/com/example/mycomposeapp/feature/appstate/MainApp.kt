package com.example.mycomposeapp.feature.appstate

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycomposeapp.feature.navigation.MainNavHost


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    appState: MainAppState = rememberMainAppState(),
) {
    Scaffold(modifier = modifier) {
        MainNavHost(navController = appState.navController, modifier = modifier.padding(it))

    }
}