package com.example.mycomposeapp.feature.category.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.mycomposeapp.feature.category.CategoryScreenRoute

const val CategoryNavigationRoute = "category_route"

fun NavController.navigateToCategory(
    navOptions: NavOptions? = null,
) {
    this.navigate(CategoryNavigationRoute, navOptions)
}

fun NavGraphBuilder.categoryScreen() {
    composable(CategoryNavigationRoute) {
        CategoryScreenRoute()
    }
}