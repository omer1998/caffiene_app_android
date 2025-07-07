package com.example.caffeine.screen.drinkDetail

enum class CupSize {
    S,
    M,
    L
}

fun CupSize.scale (): Float{
    return when (this){
        CupSize.S -> 0.7f
        CupSize.M -> 1f
        CupSize.L -> 1.3f
    }
}