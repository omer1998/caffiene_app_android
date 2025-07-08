package com.example.caffeine.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.component.AppBar
import com.example.caffeine.component.AppPrimaryButton
import com.example.caffeine.component.AppScaffold
import com.example.caffeine.component.CircularButton
import com.example.caffeine.navigation.HomeRoute
import com.example.caffeine.navigation.localNavigationController
import com.example.caffeine.ui.theme.singlet
import com.example.caffeine.ui.theme.urbanist

@Composable
fun SnackDetailScreen(
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier
) {
    val navController = localNavigationController.current
    AppScaffold(
        appBar = {
            AppBar(
                leading = {
                    CircularButton(
                        onClick = {
                            navController.popBackStack(
                                HomeRoute,
                                inclusive = false
                            )
                        }, icon = ImageVector.vectorResource(R.drawable.cancel_icon)
                    )
                })
        }
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.coffee_bean),
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = Color(0xFF7C351B)
                )
                Text(
                    "More Espresso, Less Depresso",
                    fontWeight = FontWeight(400),
                    fontSize = 20.sp,
                    fontFamily = singlet,
                    letterSpacing = 0.25.sp
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.coffee_bean),
                    contentDescription = null,
                    modifier = Modifier.size(26.dp),
                    tint = Color(0xFF7C351B)
                )
            }
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier
                    .widthIn(max = 330.dp, min = 300.dp)
                    .padding(top = 24.dp),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "Bon appétit",
                    modifier = Modifier.padding(end = 8.dp),
                    fontWeight = FontWeight(700),
                    fontSize = 22.sp,
                    fontFamily = urbanist,
                    letterSpacing = 0.25.sp,
                    lineHeight = 22.sp
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.magic_wand),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xCC1F1F1F)
                )

            }
            Spacer(modifier = Modifier.weight(1f))

            AppPrimaryButton(
                title = "Thank youuu",
                icon = ImageVector.vectorResource(R.drawable.arrow_right),
                onClick = {
                    navController.popBackStack(
                        HomeRoute,
                        inclusive = false
                    )
                },
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SnackDetailScreen(R.drawable.cup_cake_item)

}