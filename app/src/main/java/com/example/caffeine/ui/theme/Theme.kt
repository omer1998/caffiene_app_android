package com.example.caffeine.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.caffeine.navigation.localNavigationController

object AppTheme {
    val color: AppColor @Composable @ReadOnlyComposable get() = localAppColors.current
}

@Composable
fun CaffeineTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val navController: NavHostController = rememberNavController()
    val appColor = when (darkTheme) {
        true -> darkColors
        false -> lightColors
    }
    CompositionLocalProvider(
        localAppColors provides appColor,
        localNavigationController provides navController
        ) {
        content()
    }

}
