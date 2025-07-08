package com.example.caffeine.screen.snackScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.modifier.myShadow

@Composable
fun SnackCard(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(
                width = 260.dp,
                height = 274.dp
            )
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(
                    topEnd = 32.dp,
                    bottomEnd = 32.dp
                )
            )
    ) {
        Image(
            painter = painterResource(R.drawable.cup_cake_item),
            contentDescription = null,
            modifier = Modifier.size(144.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewSnackCard() {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .myShadow(
                shape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp),
                offsetX = 2.dp,
                offsetY = 4.dp,
                blurRadius = 20.dp,
                color = Color(0x1F000000)
            )
    ) {
        SnackCard()
    }
}