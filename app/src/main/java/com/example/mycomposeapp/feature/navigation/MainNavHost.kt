package com.example.mycomposeapp.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier=Modifier, startDestination: String= LoginNavigationRoute) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ){
       loginScreen()
    }
}