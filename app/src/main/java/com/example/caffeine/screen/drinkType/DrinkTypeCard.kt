package com.example.caffeine.screen.drinkType

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.urbanist

@Composable
fun DrinkTypeCard(
    scale: Float, @DrawableRes imageId: Int, name: String, modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .width(250.dp)
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier = Modifier.height((scale * 250).dp)
        )
        Text(
            name, modifier = Modifier.padding(top = 16.dp),
            fontWeight = FontWeight(700),
            fontSize = 32.sp,
            fontFamily = urbanist
        )
    }
}


@Preview(backgroundColor = 0xFF707070, showBackground = true)
@Composable
private fun PreviewDrinkTypeCard() {
    DrinkTypeCard(1f, R.drawable.latte_cup, "Coffee")
}