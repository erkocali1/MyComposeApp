package com.example.mycomposeapp.feature.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mycomposeapp.R
import com.example.mycomposeapp.feature.home.navigaiton.HomeNavigationRoute

enum class TopLevelDestination(
    val route: String,
    val selectedIcon: Icon,
    val unSelectedIcon: Icon,
    val titleTextId: Int
) {
    HOME(
        route = HomeNavigationRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Home),
        unSelectedIcon = Icon.ImageVectorIcon(AppIcons.HomeOutlined),
        titleTextId = R.string.home_title
    ),
    CATEGORY(
        route = "CategoryNavigationRoute",
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Category),
        unSelectedIcon = Icon.ImageVectorIcon(AppIcons.CategoryOutlined),
        titleTextId = R.string.category_title
    ),
    PROFILE(
        route = "ProfileNavigationRoute",
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Person),
        unSelectedIcon = Icon.ImageVectorIcon(AppIcons.PersonOutlined),
        titleTextId = R.string.profile_title
    )
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()

    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}

object AppIcons {
    val Home = Icons.Default.Home
    val HomeOutlined = Icons.Outlined.Home
    val Category = Icons.Default.Info
    val CategoryOutlined = Icons.Outlined.Info
    val Person = Icons.Default.Person
    val PersonOutlined = Icons.Outlined.Person
}