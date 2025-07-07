package com.example.caffeine.screen.drinkType

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.component.AppPrimaryButton
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.navigation.DrinkDetailRoute
import com.example.caffeine.navigation.localNavigationController
import com.example.caffeine.screen.home.HomeAppBar


@Composable
fun DrinkTypeScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { drinksList.size }
    )
    val selectedDrink by remember {
        mutableStateOf(pagerState.currentPage)
    }

    val navController = localNavigationController.current

    AppScaffold(
        horizontalPadding = 0.dp,
        appBar = { HomeAppBar(modifier = Modifier.padding(horizontal = 16.dp)) }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Good Morning", modifier = Modifier.padding(top = 16.dp)
            )
            Text("Hamsa ☀")
            Text("What would you like to drink today?")
            HorizontalPager(
                reverseLayout = true,
                modifier = Modifier
                    .padding(top = 56.dp)
                    .height(300.dp)
                    .fillMaxWidth(),
                pageSize = PageSize.Fixed(200.dp),
                contentPadding = PaddingValues(
                    horizontal = (LocalConfiguration.current.screenWidthDp.dp - 200.dp) / 2,
                ),
                state = pagerState,
            ) { index ->
                val height by animateDpAsState(
                    animationSpec = TweenSpec(
                        durationMillis = 400,
                        easing = LinearOutSlowInEasing
                    ),
                    targetValue = if (index == pagerState.currentPage) 244.dp else 150.dp
                )
                val width by animateDpAsState(
                    animationSpec = TweenSpec(
                        durationMillis = 400,
                        easing = LinearOutSlowInEasing
                    ),
                    targetValue = if (index == pagerState.currentPage) 200.dp else 119.dp
                )
                DrinkTypeCard(
                    height = height,
                    width = width,
                    imageId = drinksList[index].image,
                    name = drinksList[index].name,
                )


            }
            Spacer(modifier = Modifier.weight(1f))
            AppPrimaryButton(
                title = "continue",
                icon = ImageVector.vectorResource(R.drawable.arrow_right),
                onClick = {
                    navController.navigate(DrinkDetailRoute(type = drinksList[selectedDrink].name))
                },
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDrinkTypeScreen() {
    DrinkTypeScreen()
}