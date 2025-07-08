package com.example.caffeine.screen.snackScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.component.CircularButton
import com.example.caffeine.modifier.myShadow
import com.example.caffeine.modifier.noRippleClickable
import com.example.caffeine.ui.theme.urbanist
import kotlin.math.abs

val snackList = listOf(
    R.drawable.cup_cake_item,
    R.drawable.biscuit_item,
    R.drawable.cup_cake_item,
    R.drawable.cup_cake_item,
    R.drawable.cup_cake_item,
    R.drawable.cup_cake_item
)

@Composable
fun SnackScreen(
    modifier: Modifier = Modifier
) {
//    val scrollState = rememberScrollState()
//    val normalizedScroll = (scrollState.value.toFloat()/1000f).coerceIn(0f,1f)
//    val zIndex = lerp(0, 100, normalizedScroll).toFloat()
//    val rotation = lerp(-10, -10, normalizedScroll).toFloat()
//    val xElementOffset = lerp(0, -20,normalizedScroll).toFloat()

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { snackList.size }
    )
    AppScaffold(
        horizontalPadding = 0.dp,
        verticalPadding = 0.dp,
        appBar = {
            AppBar(
                modifier = Modifier.padding(horizontal = 16.dp ),
                leading = {
                    CircularButton(
                        onClick = {},
                        icon = ImageVector.vectorResource(R.drawable.cancel_icon)
                    )
                }
            )
        }
    ) {

//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(scrollState)
//        ) {
//            SnackCard(
//                modifier = Modifier
//                    .zIndex(zIndex)
//                    .offset(x = xElementOffset.dp)
//                    .rotate(rotation)
//                    .myShadow(
//                    shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
//                    offsetX = 2.dp,
//                    offsetY = 4.dp,
//                    blurRadius = 20.dp,
//                    color = Color(0x1F000000)
//                )
//            )
//            SnackCard(
//                modifier = Modifier
//                    .zIndex(zIndex)
//                    .offset(x = xElementOffset.dp, y = -20.dp)
//                    .rotate(rotation)
//                    .myShadow(
//                        shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
//                        offsetX = 2.dp,
//                        offsetY = 4.dp,
//                        blurRadius = 20.dp,
//                        color = Color(0x1F000000)
//                    )
//            )
//            SnackCard(
//                modifier = Modifier
//                    .zIndex(zIndex)
//                    .offset(x = xElementOffset.dp,y = -20.dp)
//                    .rotate(rotation)
//                    .myShadow(
//                        shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
//                        offsetX = 2.dp,
//                        offsetY = 4.dp,
//                        blurRadius = 20.dp,
//                        color = Color(0x1F000000)
//                    )
//            )
//            SnackCard(
//                modifier = Modifier
//                    .zIndex(zIndex)
//                    .offset(x = xElementOffset.dp, y = -20.dp)
//                    .rotate(rotation)
//                    .myShadow(
//                        shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
//                        offsetX = 2.dp,
//                        offsetY = 4.dp,
//                        blurRadius = 20.dp,
//                        color = Color(0x1F000000)
//                    )
//            )
//        }
        Column() {
            Text(
                "Take your snack",
                fontFamily = urbanist,
                fontSize = 22.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    bottom = 24.dp
                )
            )
            CircularStackCardList(
                listOf(
                    R.drawable.cup_cake_item,
                    R.drawable.biscuit_item,
                    R.drawable.cup_cake_item,
                    R.drawable.cup_cake_item,
                    R.drawable.cup_cake_item,
                    R.drawable.cup_cake_item
                )
            )
        }


        //I think it can be done in vertical pager
//        VerticalPager(
//            state = pagerState,
//            modifier = Modifier.fillMaxSize(),
//            contentPadding = PaddingValues(vertical = 300.dp)
//        ) { page ->
//
//            val currentOffset = (
//                    (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
//                    )
//
//            val rotation = lerp(
//                start = -10f,
//                stop = 10f,
//                fraction = currentOffset.coerceIn(-1f, 1f)
//            )
//
//            var transX = lerp(
//                start = -20f,
//                stop = 20f,
//                fraction = currentOffset.coerceIn(-1f, 1f)
//            )
//
//            SnackCard(
//                modifier = Modifier
//                    .graphicsLayer {
//                        rotationZ = rotation
//                        translationX = transX
//                    }
//                    .zIndex(-abs(currentOffset)) // center page on top
//                    .myShadow(
//                        shape = RoundedCornerShape(24.dp),
//                        offsetX = 2.dp,
//                        offsetY = 4.dp,
//                        blurRadius = 20.dp,
//                        color = Color(0x1F000000)
//                    )
//            )
//        }
//
//
//    }
    }
}

@Preview
@Composable
private fun PreviewSnackScreen() {
    SnackScreen()
}

@Composable
fun CircularStackCardList(
    items: List<Int>, // list of drawable ids for example
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    val centerIndex = remember { derivedStateOf { listState.firstVisibleItemIndex } }

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(vertical = 100.dp),
        verticalArrangement = Arrangement.spacedBy((-60).dp), // negative spacing to stack
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        itemsIndexed(items) { index, item ->
            val distanceFromCenter = abs(centerIndex.value - index)
            val scale = 1f - (distanceFromCenter * 0.1f).coerceAtLeast(0f)
            val rotation = (distanceFromCenter * 5).toFloat()
            val xOffset = (distanceFromCenter * -20).toFloat()
            Box(
                modifier = Modifier
                    .width(260.dp)
                    .height(270.dp)
                    .rotate(rotation)
                    .offset(x = xOffset.dp)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        translationY = distanceFromCenter * 10f
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
                    .background(Color.White)
                    .noRippleClickable {

                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = item),
                    contentDescription = null,
                    modifier = Modifier.run { size(144.dp) }
                )
            }
        }
    }
}
