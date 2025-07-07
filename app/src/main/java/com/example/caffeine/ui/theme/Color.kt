package com.example.caffeine.ui.theme

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


// Light Mode Colors
val CaffeineCream = Color(0xFFF5F5F5)   // Adjust based on actual hex
val CaffeineFoam = Color(0xFFFFEEE7)  // Soft pinkish-beige
val CaffeineRoast = Color(0xFF7C351B)// Rich brown
val CaffeineBeans = Color(0xFF291710) // Darker brown
val CaffeineEspresso = Color(0xFF030004) // Near black


// Dark Mode Colors
val CaffeineDarkCream = Color(0xFF0A0505) // Near black for background
val CaffeineDarkFoam = Color(0xFF2C1A13)  // Slightly lighter for surfaces
val CaffeineDarkRoast = Color(0xFF7A3E2B) // Keep as is (primary still pops)
val CaffeineDarkBeans = Color(0xFFEEE6E0) // Light onPrimary or text
val CaffeineDarkEspresso = Color(0xFFF5F5F5) // Lightest (contrast)


open class AppColor(
    val caffeineRoast: Color,
    val caffeineBeans: Color,
    val caffeineFoam: Color,
    val caffeineCream: Color,
    val caffeineEspresso: Color,
)

val lightColors = AppColor(
    caffeineRoast = CaffeineRoast,
    caffeineBeans = CaffeineBeans,
    caffeineFoam = CaffeineFoam,
    caffeineCream = CaffeineCream,
    caffeineEspresso = CaffeineEspresso
)
val darkColors = AppColor(
    caffeineRoast = CaffeineDarkRoast,
    caffeineBeans = CaffeineDarkBeans,
    caffeineFoam = CaffeineDarkFoam,
    caffeineCream = CaffeineDarkCream,
    caffeineEspresso = CaffeineDarkEspresso
)


val localAppColors = staticCompositionLocalOf<AppColor> { lightColors }