package com.example.caffeine.screen.drinkDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.component.AppBar
import com.example.caffeine.component.AppPrimaryButton
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.component.CircularButton

@Composable
fun DrinkDetailScreen(title: String, modifier: Modifier = Modifier) {
    AppScaffold(
        appBar = {
            AppBar(
                leading = {
                    CircularButton(
                        onClick = {},
                        icon = ImageVector.vectorResource(R.drawable.back_arrow)
                    )
                },
                title = { Text(title) },
            )
        }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(Modifier.fillMaxWidth()){
                    Image(
                        painter = painterResource(R.drawable.cup_size),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 50.dp)
                        // contentScale = ContentScale.Crop

                    )
                    Text("200 Ml", modifier = Modifier.align(alignment = Alignment.TopStart))

                }

                Image(
                    modifier = Modifier
                        .size(66.dp)
                        .align(alignment = Alignment.Center),
                    contentDescription = null,
                    painter = painterResource(R.drawable.the_shance_coffee)
                )
            }

            CupSizeOption(
                currentSize = CupSize.L,
                onClick = {}
            )
            CoffeeAmountOption(
                modifier = Modifier.padding(top = 16.dp),
                onClick = {},
                currentCoffeeAmount = CoffeeAmount.MEDIUM
            )

            Spacer(modifier = Modifier.weight(1f))

            AppPrimaryButton(
                title = "continue",
                icon = ImageVector.vectorResource(R.drawable.arrow_right),
                onClick = {},
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewDrinkDetail() {
    DrinkDetailScreen("Coffee")
}