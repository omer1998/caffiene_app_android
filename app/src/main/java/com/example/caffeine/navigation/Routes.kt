package com.example.caffeine.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.caffeine.screen.DrinkReadyScreen
import com.example.caffeine.screen.drinkDetail.DrinkDetailScreen
import com.example.caffeine.screen.drinkType.DrinkTypeScreen
import com.example.caffeine.screen.home.HomeScreen
import kotlinx.serialization.Serializable

val localNavigationController = compositionLocalOf<NavHostController> {
    throw IllegalArgumentException("No navigation controller provided")
}
sealed interface AppRoute
@Serializable
object HomeRoute : AppRoute

@Serializable
object DrinkTypeRoute : AppRoute

@Serializable
data class DrinkDetailRoute(val type: String) : AppRoute

@Serializable
object DrinkReadyRoute : AppRoute

fun NavGraphBuilder.home() {
    composable<HomeRoute> {
        HomeScreen()
    }
}

fun NavGraphBuilder.drinkType() {
    composable<DrinkTypeRoute> {
        DrinkTypeScreen()
    }
}
fun NavGraphBuilder.drinkDetail() {
    composable<DrinkDetailRoute> { navStack ->
        val type = navStack.toRoute<DrinkDetailRoute>().type
        DrinkDetailScreen(title = type)
    }
}

fun NavGraphBuilder.drinkReady(){
    composable<DrinkReadyRoute> {
        DrinkReadyScreen()
    }
}