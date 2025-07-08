package com.example.caffeine.screen.snackScreen.component

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.abs

@Composable
fun SnacksCardList(
    items: List<Int>,
    onItemClick: (imageId: Int)-> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    LaunchedEffect(Unit) {
        listState.requestScrollToItem(1, 0)
    }
    val centerIndex = remember { derivedStateOf { listState.firstVisibleItemIndex } }

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(vertical = 110.dp),
        verticalArrangement = Arrangement.spacedBy((-60).dp), // negative spacing to stack
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        itemsIndexed(items) { index, item ->
            val distanceFromCenter = index - centerIndex.value // signed value
            val absDistance = abs(distanceFromCenter)

            val scale by animateFloatAsState(
                targetValue = 1f - (absDistance * 0.1f).coerceAtLeast(0f),
                animationSpec = TweenSpec(durationMillis = 300)
            )
            val rotation by animateFloatAsState(
                targetValue = distanceFromCenter * 10f,
                animationSpec = TweenSpec(durationMillis = 300)
            )
            val xOffset by animateFloatAsState(
                targetValue = absDistance * -20f,
                animationSpec = TweenSpec(durationMillis = 300)
            )
            val transY by animateFloatAsState(
                targetValue = absDistance * 10f,
                animationSpec = TweenSpec(durationMillis = 300)
            )
            SnackCard(
                onClick = {},
                rotation = rotation,
                xOffset = xOffset,
                transY = transY,
                scale = scale,
                distanceFromCenter = distanceFromCenter,
                imageId = item,
            )
        }
    }
}
