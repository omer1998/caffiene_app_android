package com.example.caffeine.screen.home

import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.component.AppBar
import com.example.caffeine.component.AppPrimaryButton
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.component.CircularButton
import com.example.caffeine.navigation.DrinkTypeRoute
import com.example.caffeine.navigation.localNavigationController
import com.example.caffeine.screen.drinkType.DrinkTypeScreen

@Composable
fun HomeScreen( modifier: Modifier = Modifier) {
    val navController = localNavigationController.current

    AppScaffold(
        appBar = {
            HomeAppBar()
        }
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    "Hocus\n" +
                            "Pocus\n" +
                            "I Need Coffee\n" +
                            "to Focus",
                    fontSize = 32.sp,
                    lineHeight = 50.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.CenterStart)
                        .offset(y = -20.dp)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.TopEnd)
                        .offset(y = 10.dp)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = 20.dp)
                )
            }

            Image(
                painter = painterResource(R.drawable.coffee_ghost),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 33.dp)
                    .size(244.dp),
                contentScale = ContentScale.Fit
            )

            OvalShape(
                color = Color(0x241F1F1F), modifier = Modifier
                    .height(27.dp)
                    .width(177.dp)
                    .clip(CustomOvalShape())
                    .blur(50.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
            )
            Spacer(modifier = Modifier.weight(1f))

            AppPrimaryButton(
                title = "bring my coffee",
                icon = ImageVector.vectorResource(R.drawable.coffee_cup),
                onClick = {
                    navController.navigate(DrinkTypeRoute)
                }
            )

        }


    }
}

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

@Preview(showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}