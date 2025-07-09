package com.example.caffeine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.caffeine.navigation.HomeRoute
import com.example.caffeine.navigation.drinkDetail
import com.example.caffeine.navigation.drinkReady
import com.example.caffeine.navigation.drinkType
import com.example.caffeine.navigation.home
import com.example.caffeine.navigation.localNavigationController
import com.example.caffeine.navigation.snackDetail
import com.example.caffeine.navigation.snackScreen
import com.example.caffeine.ui.theme.CaffeineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaffeineTheme {
                NavHost(
                    navController = localNavigationController.current,
                    startDestination = HomeRoute,
                    modifier = Modifier
                ) {
                    home()
                    drinkType()
                    drinkDetail()
                    drinkReady()
                    snackScreen()
                    snackDetail()
                }
            }
        }
    }
}

