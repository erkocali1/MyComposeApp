package com.example.mycomposeapp.feature.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mycomposeapp.feature.splash.SplashScreenRoute

const val SplashNavigationRoute = "splash_route"

fun NavGraphBuilder.splashScreen(
    navigateToHOme: () -> Unit,
    navigateToLogin: () -> Unit
) {
    composable(SplashNavigationRoute) {
        SplashScreenRoute(navigateToHome =navigateToHOme, navigateToLogin =navigateToLogin)
    }
}