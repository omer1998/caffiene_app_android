package com.example.caffeine.screen.drinkType

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.caffeine.component.AppPrimaryButton
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.navigation.DrinkDetailRoute
import com.example.caffeine.navigation.localNavigationController
import com.example.caffeine.screen.home.HomeAppBar
import com.example.caffeine.ui.theme.urbanist


@Composable
fun DrinkTypeScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { drinksList.size }
    )

    val navController = localNavigationController.current

    AppScaffold(
        horizontalPadding = 0.dp,
        appBar = { HomeAppBar(modifier = Modifier.padding(horizontal = 16.dp)) }) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .fillMaxWidth(),
                text = "Good Morning",
                fontWeight = FontWeight(700),
                fontFamily = urbanist,
                fontSize = 36.sp,
                letterSpacing = 0.25.sp,
                color = Color(0xFFB3B3B3),
                textAlign = TextAlign.Start
            )
            Text(
                "Hamsa ☀",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
                fontWeight = FontWeight(700),
                fontFamily = urbanist,
                fontSize = 36.sp,
                letterSpacing = 0.25.sp,
                color = Color(0xFF3B3B3B),
                textAlign = TextAlign.Start
            )
            Text(
                "What would you like to drink today?",
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp
                    )
                    .fillMaxWidth(),
                fontWeight = FontWeight(700),
                fontFamily = urbanist,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp,
                color = Color(0xCC1F1F1F),
                textAlign = TextAlign.Start
            )
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
                val scaleImage by animateFloatAsState(
                    animationSpec = TweenSpec(
                        durationMillis = 450,
                        easing = LinearOutSlowInEasing
                    ),
                    targetValue = if (index == pagerState.currentPage) 1f else 0.7f
                )
                DrinkTypeCard(
                    scale = scaleImage,
                    imageId = drinksList[index].image,
                    name = drinksList[index].name,
                )


            }
            Spacer(modifier = Modifier.weight(1f))
            AppPrimaryButton(
                title = "continue",
                icon = ImageVector.vectorResource(R.drawable.arrow_right),
                onClick = {
                    navController.navigate(DrinkDetailRoute(type = drinksList[pagerState.currentPage].name))
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