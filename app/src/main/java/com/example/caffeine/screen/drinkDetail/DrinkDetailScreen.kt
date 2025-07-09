package com.example.caffeine.screen.drinkDetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.component.AppBar
import com.example.caffeine.component.AppPrimaryButton
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.component.CircularButton
import com.example.caffeine.navigation.DrinkReadyRoute
import com.example.caffeine.navigation.localNavigationController
import com.example.caffeine.screen.drinkDetail.component.AlmostDoneSection
import com.example.caffeine.screen.drinkDetail.component.HeaderImageSection
import com.example.caffeine.screen.drinkDetail.component.LoadingIndicator
import com.example.caffeine.screen.drinkDetail.component.SelectionOptions
import com.example.caffeine.ui.theme.urbanist
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun DrinkDetailScreen(title: String, modifier: Modifier = Modifier) {
    val navController = localNavigationController.current
    val screenHeight = LocalConfiguration.current.screenHeightDp.toFloat()

    var currentCupSize by remember { mutableStateOf(CupSize.M) }
    var currentCoffeeAmount by remember { mutableStateOf(CoffeeAmount.MEDIUM) }
    var almostDoneVisible by remember { mutableStateOf(false) }
    var isShowTopBar by remember { mutableStateOf(true) }

    val cupScale = remember { Animatable(1f) }
    val offsetY = remember { Animatable(-300f) }
    val alpha = remember { Animatable(1f) }
    val appBarOffset = remember { Animatable(screenHeight) }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        launch {
            appBarOffset.animateTo(0f, TweenSpec(durationMillis = 1000))
        }
        launch {
            offsetY.animateTo(30f, TweenSpec(durationMillis = 2500))
        }
        alpha.animateTo(0f, TweenSpec(durationMillis = 2500))
    }

    AppScaffold(
        appBar = {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
            ) {
                AnimatedVisibility(
                    visible = isShowTopBar,
                    enter = slideInVertically(animationSpec = tween(700)) { -it * 2 },
                    exit = slideOutVertically(animationSpec = tween(700)) { -it * 2 }) {
                    AppBar(modifier = Modifier.offset(y = appBarOffset.value.dp), leading = {
                        CircularButton(
                            onClick = { /* handle back */ },
                            icon = ImageVector.vectorResource(R.drawable.back_arrow)
                        )
                    }, title = {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Bold,
                            fontFamily = urbanist,
                            fontSize = 24.sp,
                            letterSpacing = 0.25.sp,
                            color = Color(0xDE1F1F1F),
                            textAlign = TextAlign.Start
                        )
                    })
                }
            }

        }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HeaderImageSection(
                modifier,
                cupScale = cupScale.value,
                offsetY = offsetY.value,
                alpha = alpha.value,
                cupSizeLabel = currentCupSize.getSize().toString()
            )

            AnimatedVisibility(!almostDoneVisible) {
                SelectionOptions(currentCupSize = currentCupSize, onCupSizeSelected = {
                    currentCupSize = it
                    scope.launch {
                        cupScale.animateTo(
                            it.scale(), animationSpec = TweenSpec(400)
                        )
                    }
                }, currentCoffeeAmount = currentCoffeeAmount, onCoffeeAmountSelected = {
                    currentCoffeeAmount = it
                    scope.launch {
                        alpha.snapTo(1f)
                        offsetY.snapTo(-300f)
                        offsetY.animateTo(30f, TweenSpec(2500))
                        alpha.animateTo(0f, TweenSpec(2500))
                    }
                })
            }

            Spacer(modifier = Modifier.weight(1f))



            AnimatedVisibility(
                visible = !almostDoneVisible, enter = fadeIn(
                    animationSpec = TweenSpec(100)

                ), exit = fadeOut(
                    animationSpec = TweenSpec(100)

                )
            ) {
                AppPrimaryButton(
                    modifier = Modifier.animateEnterExit(
                        exit = fadeOut(
                            animationSpec = TweenSpec(200)
                        ), enter = fadeIn(
                            animationSpec = TweenSpec(200)
                        )
                    ),
                    title = "Continue",
                    icon = ImageVector.vectorResource(R.drawable.arrow_right),
                    onClick = {
                        isShowTopBar = false
                        almostDoneVisible = true
                        scope.launch {
                            delay(4000)
                            navController.navigate(DrinkReadyRoute)
                        }
                    })
            }
            AnimatedVisibility(
                visible = almostDoneVisible, enter = fadeIn(
                    animationSpec = TweenSpec(400)
                ), exit = fadeOut(
                    animationSpec = TweenSpec(400)
                )
            ) {
                Column(Modifier.fillMaxWidth()) {
                    LoadingIndicator()
                    Spacer(Modifier.height(37.dp))
                    AlmostDoneSection()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewDrinkDetail() {
    DrinkDetailScreen("Coffee")
}