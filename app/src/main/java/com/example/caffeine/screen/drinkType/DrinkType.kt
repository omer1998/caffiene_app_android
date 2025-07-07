package com.example.caffeine.screen.drinkType

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.caffeine.R

data class DrinkType(
    val name: String,
    val image: Int
)

val drinksList = listOf<DrinkType>(
    DrinkType("Espresso", R.drawable.espresso_cup),
    DrinkType("Black", R.drawable.balck_cup),
    DrinkType("Latte", R.drawable.latte_cup),
    DrinkType("Macchiato", R.drawable.macchiato_cup),

    )