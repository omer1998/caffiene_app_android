package com.example.caffeine.screen.drinkDetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.component.AppBar
import com.example.caffeine.component.AppPrimaryButton
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.component.CircularButton
import com.example.caffeine.navigation.DrinkReadyRoute
import com.example.caffeine.navigation.localNavigationController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DrinkDetailScreen(title: String, modifier: Modifier = Modifier) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.toFloat()
    var currentCupSize by remember { mutableStateOf(CupSize.M) }
    var currentCoffeeAmount by remember { mutableStateOf(CoffeeAmount.MEDIUM) }
    val cupScale by remember { mutableStateOf(1f) }
    var cupScaleAnimatable = remember { Animatable(cupScale) }
    val offsetY = remember { Animatable(-300f) }
    val alpha = remember { Animatable(1f) }
    val appBarOffset = remember {Animatable(screenHeight)}
    var almostDoneVisible by remember { mutableStateOf(false) }
    var isShowTopBar by remember { mutableStateOf(true) }

    val navController = localNavigationController.current

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            appBarOffset.animateTo(
                targetValue = 0f,
                animationSpec = TweenSpec(durationMillis = 1000)
            )
        }
        scope.launch {
            offsetY.animateTo(
                targetValue = 30f,
                animationSpec = TweenSpec(durationMillis = 2500)
            )
        }

        alpha.animateTo(
            targetValue = 0f,
            animationSpec = TweenSpec(durationMillis = 2500)
        )

    }
    AppScaffold(
        appBar = {
            AnimatedVisibility(
                isShowTopBar,
                enter = slideInVertically(animationSpec = TweenSpec(durationMillis = 700)) { it ->
                    -it * 2
                },
                exit = slideOutVertically(animationSpec = TweenSpec(durationMillis = 700)) { it ->
                    -it * 2
                }
            )
            {
                AppBar(
                    modifier = Modifier.offset(y= appBarOffset.value.dp),
                    leading = {
                        CircularButton(
                            onClick = {}, icon = ImageVector.vectorResource(R.drawable.back_arrow)
                        )
                    },
                    title = { Text(title) },
                )
            }
        }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentAlignment = Alignment.Center
            ) {
                //FallingBean(currentCoffeeAmount.name)
                Image(
                    painter = painterResource(id = R.drawable.coffee_beans),
                    contentDescription = "Coffee Beans",
                    modifier = modifier
                        .offset(y = offsetY.value.dp)
                        .alpha(alpha.value)
                        .size(width = 100.dp, height = 150.dp)
                )
                Box(Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(R.drawable.cup_size),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 50.dp)
                            .scale(cupScaleAnimatable.value)

                        // contentScale = ContentScale.Crop

                    )

                    Text(
                        "200 Ml",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(y = 50.dp)
                    )

                }

                Image(
                    modifier = Modifier
                        .size(66.dp)
                        .align(alignment = Alignment.Center),
                    contentDescription = null,
                    painter = painterResource(R.drawable.the_shance_coffee)
                )
            }
            AnimatedVisibility(!almostDoneVisible) {
                Column {
                    CupSizeOption(
                        currentSize = currentCupSize, onClick = {
                            currentCupSize = it
                            scope.launch {
                                cupScaleAnimatable.animateTo(targetValue = it.scale())

                            }
                        })
                    CoffeeAmountOption(
                        modifier = Modifier.padding(top = 16.dp), onClick = {
                            scope.launch {

                                alpha.snapTo(1f)
                                offsetY.snapTo(-300f)
                                offsetY.animateTo(
                                    targetValue = 30f,
                                    animationSpec = TweenSpec(durationMillis = 2500)
                                )
                                alpha.animateTo(
                                    targetValue = 0f,
                                    animationSpec = TweenSpec(durationMillis = 2500)
                                )


                            }
                            currentCoffeeAmount = it

                        }, currentCoffeeAmount = currentCoffeeAmount
                    )
                }
            }


            Spacer(modifier = Modifier.weight(1f))

            Crossfade(
                targetState = almostDoneVisible,
                label = "crossFade animation"

            ) {
                if (it) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        LoadingIndicator()
                        Spacer(modifier.height(37.dp))
                        AlmostDoneSection()
                    }


                } else {
                    AppPrimaryButton(
                        title = "continue",
                        icon = ImageVector.vectorResource(R.drawable.arrow_right),
                        onClick = {
                            isShowTopBar = !isShowTopBar
                            almostDoneVisible = true
                            scope.launch {
                                delay(4000)
                                navController.navigate(DrinkReadyRoute)
                            }
                        },
                    )

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