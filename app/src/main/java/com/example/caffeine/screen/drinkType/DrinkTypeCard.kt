package com.example.caffeine.screen.drinkType

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DrinkTypeCard(
    height: Dp, width: Dp, @DrawableRes imageId: Int, name: String, modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.width(200.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier = Modifier
                .height(
                    height
                )
                .width(width)
        )
        Text(
            name, modifier = Modifier.padding(top = 16.dp)
        )
    }
}