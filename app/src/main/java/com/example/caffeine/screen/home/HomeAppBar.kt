package com.example.caffeine.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.example.caffeine.R
import com.example.caffeine.component.AppBar
import com.example.caffeine.component.CircularButton

@Composable
fun HomeAppBar(modifier: Modifier = Modifier) {
    AppBar(
        modifier = modifier,
        leading = {
            CircularButton(
                onClick = {},
                image = painterResource(R.drawable.ghost_with_coffee)
            )
        },
        actions = {
            CircularButton(
                onClick = {},
                icon = ImageVector.vectorResource(R.drawable.add_icon)
            )
        }
    )
}