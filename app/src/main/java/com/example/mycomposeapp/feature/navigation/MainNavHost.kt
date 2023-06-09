package com.example.mycomposeapp.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.mycomposeapp.feature.category.navigation.categoryScreen
import com.example.mycomposeapp.feature.profile.navigation.profileScreen
import com.example.mycomposeapp.feature.home.navigaiton.HomeNavigationRoute
import com.example.mycomposeapp.feature.home.navigaiton.homeScreen
import com.example.mycomposeapp.feature.productdetail.navigateToProductDetail
import com.example.mycomposeapp.feature.productdetail.productDetailScreen
import com.example.mycomposeapp.feature.splash.navigation.SplashNavigationRoute
import com.example.mycomposeapp.feature.splash.navigation.splashScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = SplashNavigationRoute
) {
    NavHost(
        navController = navController, modifier = modifier, startDestination = startDestination
    ) {
        loginScreen()
        homeScreen(navigateToDetail ={ id->
            navController.navigateToProductDetail(id)
        })
        splashScreen(navigateToLogin = {
            navController.navigate(LoginNavigationRoute) {
                popUpTo(LoginNavigationRoute) {
                    inclusive = true
                }
            }
        }, navigateToHOme = {
            navController.navigate(HomeNavigationRoute) {
                popUpTo(LoginNavigationRoute) {
                    inclusive = true
                }
            }
        })
        profileScreen()
        categoryScreen()
        productDetailScreen()
    }
}