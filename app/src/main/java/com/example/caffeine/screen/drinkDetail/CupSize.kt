package com.example.caffeine.screen.drinkDetail

enum class CupSize {
    S,
    M,
    L
}

fun CupSize.scale (): Float{
    return when (this){
        CupSize.S -> 0.8f
        CupSize.M -> 1f
        CupSize.L -> 1.2f
    }
}

fun CupSize.getSize(): Int{
    return when (this){
        CupSize.S -> 150
        CupSize.M -> 200
        CupSize.L -> 400
    }
}