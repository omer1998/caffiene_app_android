package com.example.caffeine.screen.home

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode.Reverse
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.component.AppPrimaryButton
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.navigation.DrinkTypeRoute
import com.example.caffeine.navigation.localNavigationController
import com.example.caffeine.screen.home.component.CoffeeGhostWithShadow

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val navController = localNavigationController.current
    val infiniteTransition = rememberInfiniteTransition()
    val starOpacity = infiniteTransition.animateFloat(
        0.2f, 1f, animationSpec = InfiniteRepeatableSpec(
            animation = TweenSpec(durationMillis = 200),
            repeatMode = Reverse
        )
    )
    val starOpacity2 = infiniteTransition.animateFloat(
        0.2f,
        1f,
        animationSpec = InfiniteRepeatableSpec(
            animation = TweenSpec(durationMillis = 400),
            repeatMode = Reverse
        )
    )
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
                        .alpha(starOpacity.value)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.TopEnd)
                        .offset(y = 10.dp)
                        .alpha(starOpacity2.value)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = 20.dp)
                        .alpha(starOpacity.value)
                )
            }

            CoffeeGhostWithShadow()

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

@Preview(showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}