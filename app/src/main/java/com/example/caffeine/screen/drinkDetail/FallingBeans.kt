package com.example.caffeine.screen.drinkDetail

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import kotlinx.coroutines.delay

@Composable
fun FallingBean(
    coffeeAmount: String,
    modifier: Modifier = Modifier,
    startOffsetY: Dp = (-200).dp,
    endOffsetY: Dp = 50.dp,
    durationMillis: Int = 1500,
    delayMillis: Int = 0,
    onEnd: () -> Unit = {}
) {
    val offsetY = remember { Animatable(startOffsetY.value) }
    val alpha = remember { Animatable(1f) }

    LaunchedEffect(coffeeAmount) {
        // Delay before starting
        delay(delayMillis.toLong())

        // Animate drop
        offsetY.animateTo(
            targetValue = endOffsetY.value,
            animationSpec = tween(durationMillis)
        )

        // Animate fade out
        alpha.animateTo(
            targetValue = 0f,
            animationSpec = tween(500)
        )

        // Callback (optional)
        onEnd()
    }

    Image(
        painter = painterResource(id = R.drawable.coffee_beans),
        contentDescription = "Coffee Beans",
        modifier = modifier
            .offset(y = offsetY.value.dp)
            .alpha(alpha.value)
            .size(width = 100.dp, height = 150.dp)
    )
}