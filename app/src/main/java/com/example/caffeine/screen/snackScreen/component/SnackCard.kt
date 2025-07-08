package com.example.caffeine.screen.snackScreen.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import com.example.caffeine.modifier.myShadow
import com.example.caffeine.modifier.noRippleClickable

@Composable
fun SnackCard(
    onClick: () -> Unit,
    rotation: Float,
    xOffset: Float,
    transY: Float,
    scale: Float,
    distanceFromCenter: Int,
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .width(260.dp)
            .height(270.dp)
            .rotate(rotation)
            .offset(x = xOffset.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                translationY = transY
            }
            .zIndex((100 - distanceFromCenter).toFloat())
            .myShadow(
                shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
                offsetX = 2.dp,
                offsetY = 4.dp,
                blurRadius = 20.dp,
                color = Color(0x1F000000)
            )
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFF5F5F5))
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.run { size(144.dp) }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewSnackCard() {
    SnackCard(
        onClick = {},
        rotation = 0f,
        xOffset = 0f,
        transY = 0f,
        scale = 1f,
        imageId = R.drawable.cup_cake_item,
        distanceFromCenter = 0,
        modifier = TODO()
    )
}