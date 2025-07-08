package com.example.caffeine.modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier {
    val interactionResource = remember { MutableInteractionSource() }
    return this.clickable(
        interactionSource = interactionResource,
        indication = null
    ) {
        onClick()
    }
}