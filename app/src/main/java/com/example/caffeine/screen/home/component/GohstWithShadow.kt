package com.example.caffeine.screen.home.component

import android.graphics.BlurMaskFilter
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode.Reverse
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun CoffeeGhostWithShadow(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val imageYOffset = infiniteTransition.animateFloat(
        0f, 20f, animationSpec = InfiniteRepeatableSpec(
            animation = TweenSpec(durationMillis = 4000),
            repeatMode = Reverse
        )
    )

    val shadowOffset = infiniteTransition.animateFloat(
        0f, -10f, animationSpec = InfiniteRepeatableSpec(
            animation = TweenSpec(durationMillis = 4000),
            repeatMode = Reverse
        )
    )

    val shadowOpacity = infiniteTransition.animateFloat(
        0.07f, 0.2f, animationSpec = InfiniteRepeatableSpec(
            animation = TweenSpec(
                durationMillis = 4000,
                easing = LinearOutSlowInEasing
            ),
            repeatMode = Reverse
        )
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.coffee_ghost),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 33.dp)
                .size(244.dp)
                .offset(y = imageYOffset.value.dp),
            contentScale = ContentScale.Fit
        )

        Box(
            modifier = Modifier
                .padding(top = 15.dp)
                .size(178.dp, 28.dp)
                .offset(y = shadowOffset.value.dp)
                .drawBehind {
                    drawIntoCanvas { canvas ->
                        val paint = Paint().apply {
                            color = Color(0x241F1F1F).copy(shadowOpacity.value)
                            asFrameworkPaint().maskFilter =
                                BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL)
                        }
                        canvas.drawOval(Rect(Offset(0f, 4f), size), paint)
                    }
                }
        )
    }
}