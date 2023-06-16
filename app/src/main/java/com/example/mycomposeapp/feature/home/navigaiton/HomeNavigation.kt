package com.example.mycomposeapp.feature.home.navigaiton

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val HomeNavigationRoute = "home_route"

fun NavController.navigateToHome(
    navOptions: NavOptions? = null
) {
    this.navigate(HomeNavigationRoute,navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(HomeNavigationRoute) {
        HomeScreenRoute()
    }
}