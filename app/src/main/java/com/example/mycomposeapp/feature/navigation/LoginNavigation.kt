package com.example.mycomposeapp.feature.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mycomposeapp.feature.login.LoginScreenRoute

const val LoginNavigationRoute ="login_route"

fun NavGraphBuilder.loginScreen(){
    composable(LoginNavigationRoute){
        LoginScreenRoute()
    }
}
