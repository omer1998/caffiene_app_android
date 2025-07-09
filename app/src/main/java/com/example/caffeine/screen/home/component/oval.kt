package com.example.caffeine.screen.home.component

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


@Composable
fun OvalShape(color: Color, modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val radiusX = size.width / 2
        val radiusY = size.height / 2

        drawOval(
            color = color,
            topLeft = Offset(centerX - radiusX, centerY - radiusY),
            size = Size(radiusX * 2, radiusY * 2),
            style = Fill
        )
    }
}

class CustomOvalShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val rect = Rect(0f, 0f, size.width, size.height)
            addOval(rect)
        }
        return Outline.Generic(path)
    }

}