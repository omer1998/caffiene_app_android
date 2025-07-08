package com.example.caffeine.screen.snackScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.component.AppBar
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.component.CircularButton
import com.example.caffeine.ui.theme.urbanist

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

    AppScaffold(
        horizontalPadding = 0.dp,
        verticalPadding = 0.dp,
        appBar = {
            AppBar(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp
                ),
                leading = {
                    CircularButton(
                        onClick = {},
                        icon = ImageVector.vectorResource(R.drawable.cancel_icon)
                    )
                }
            )
        }
    ) {
        Column {
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
            SnacksCardList(
                listOf(
                    R.drawable.cup_cake_item,
                    R.drawable.biscuit_item,
                    R.drawable.croissant_item,
                    R.drawable.choclate_item,
                    R.drawable.oreo_item,
                    R.drawable.unkonw_item
                )
            )
        }

    }
}

@Preview
@Composable
private fun PreviewSnackScreen() {
    SnackScreen()
}

