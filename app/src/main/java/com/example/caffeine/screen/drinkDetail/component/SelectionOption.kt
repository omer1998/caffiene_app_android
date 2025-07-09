package com.example.caffeine.screen.drinkDetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.caffeine.screen.drinkDetail.CoffeeAmount
import com.example.caffeine.screen.drinkDetail.CupSize

@Composable
fun SelectionOptions(
    currentCupSize: CupSize,
    onCupSizeSelected: (CupSize) -> Unit,
    currentCoffeeAmount: CoffeeAmount,
    onCoffeeAmountSelected: (CoffeeAmount) -> Unit
) {
    Column {
        CupSizeOption(currentSize = currentCupSize, onClick = onCupSizeSelected)
        CoffeeAmountOption(
            modifier = Modifier.padding(top = 16.dp),
            currentCoffeeAmount = currentCoffeeAmount,
            onClick = onCoffeeAmountSelected
        )
    }
}
