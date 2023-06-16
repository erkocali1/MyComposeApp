package com.example.mycomposeapp.feature.home.navigaiton

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mycomposeapp.feature.splash.SplashScreenRoute

const val HomeNavigationRoute = "home_route"

fun NavGraphBuilder.homeScreen() {
    composable(HomeNavigationRoute) {
        HomeScreenRoute()
    }
}