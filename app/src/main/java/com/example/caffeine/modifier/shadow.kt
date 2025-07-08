package com.example.caffeine.modifier

import android.graphics.BlurMaskFilter
import android.graphics.BlurMaskFilter.Blur.NORMAL
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

fun Modifier.myShadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    shape: Shape = RectangleShape
): Modifier = drawBehind {
    val paint = Paint()
    val frameworkPaint = paint.asFrameworkPaint()

    if (blurRadius != 0.dp) {
        frameworkPaint.maskFilter = BlurMaskFilter(blurRadius.toPx(), NORMAL)
    }

    frameworkPaint.color = color.toArgb()

    // Get the outline path of the shape to draw the shadow
    val outline = shape.createOutline(size, layoutDirection = LayoutDirection.Ltr, this)

    drawIntoCanvas { canvas ->
        canvas.save()

        // Apply offset translation for the shadow
        canvas.translate(offsetX.toPx(), offsetY.toPx())
        val leftPixel = offsetX.toPx()
        val topPixel = offsetY.toPx()
        val rightPixel = size.width + topPixel
        val bottomPixel = size.height + leftPixel
        when (outline) {
            is Outline.Rectangle -> {
                canvas.drawRect(outline.rect, paint)
            }
            is Outline.Rounded -> {
                canvas.drawRoundRect(
                    leftPixel,
                    topPixel,
                    rightPixel,
                    bottomPixel,
                    radiusX = outline.roundRect.bottomRightCornerRadius.x,
                    radiusY = outline.roundRect.topRightCornerRadius.y,
                    paint
                )
            }
            is Outline.Generic -> {
                canvas.drawPath(outline.path, paint)
            }
        }

        canvas.restore()
    }
}
