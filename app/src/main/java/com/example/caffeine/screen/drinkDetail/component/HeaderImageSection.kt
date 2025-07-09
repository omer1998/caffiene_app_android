package com.example.caffeine.screen.drinkDetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.urbanist

@Composable
fun HeaderImageSection(
    modifier: Modifier,
    cupScale: Float,
    offsetY: Float,
    alpha: Float,
    cupSizeLabel: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.coffee_beans),
            contentDescription = "Coffee Beans",
            modifier = modifier
                .offset(y = offsetY.dp)
                .alpha(alpha)
                .size(width = 100.dp, height = 150.dp)
        )
        Box(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.cup_size),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 50.dp)
                    .scale(cupScale)
            )
            Text(
                text = "$cupSizeLabel ML",
                fontWeight = FontWeight.Medium,
                fontFamily = urbanist,
                fontSize = 14.sp,
                letterSpacing = 0.25.sp,
                color = Color(0x99000000),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(y = 50.dp)
            )
        }

        Image(
            painter = painterResource(R.drawable.the_shance_coffee),
            contentDescription = null,
            modifier = Modifier
                .size(66.dp)
                .align(Alignment.Center)
        )
    }
}

