package com.example.caffeine.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import com.example.caffeine.component.AppBar
import com.example.caffeine.component.AppPrimaryButton
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.component.CircularButton
import com.example.caffeine.ui.theme.AppTheme
import com.example.caffeine.ui.theme.urbanist

@Composable
fun DrinkReadyScreen(modifier: Modifier = Modifier) {
    val cupOffset = remember { Animatable(200f) }
    var isTakeAway by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        cupOffset.animateTo(
            -50f,
            animationSpec = TweenSpec(durationMillis = 1000)
        )
    }
    AppScaffold(
        appBar = {
            AppBar(
                leading = {
                    CircularButton(
                        onClick = {},
                        icon = ImageVector.vectorResource(R.drawable.cancel_icon)
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            ReadySection(modifier = Modifier.padding(bottom = 20.dp))
            Box(
                modifier = Modifier
                    .width(260.dp)
                    .height(350.dp),
                //contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.cup_cover),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(vertical = 50.dp)
                        .zIndex(1f)
                        .scale(1.06f)
                        .offset(y = -50.dp)

                )
                Image(
                    painter = painterResource(R.drawable.cup_size),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Image(
                    modifier = Modifier
                        .size(66.dp)
                        .align(alignment = Alignment.Center),
                    contentDescription = null,
                    painter = painterResource(R.drawable.the_shance_coffee)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                AppSwitch(
                    checked = isTakeAway,
                    onCheckedChange = { isTakeAway = it },
                    onColor = AppTheme.color.caffeineRoast,
                    offColor = Color(0xFFFFEEE7)
                )
                Text(
                    "Take Away",
                    modifier = Modifier.padding(start = 8.dp),
                    fontFamily = urbanist,
                    fontWeight = FontWeight(700),
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp,
                    color = Color(0xB2000000)
                )
            }
            AppPrimaryButton(
                title = "Take snack",
                icon = ImageVector.vectorResource(R.drawable.arrow_right),
                onClick = { },
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}


@Preview
@Composable
private fun PreviewDrinkReadyScreen() {
    DrinkReadyScreen()
}