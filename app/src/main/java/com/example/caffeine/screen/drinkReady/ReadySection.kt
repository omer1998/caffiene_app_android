package com.example.caffeine.screen.drinkReady

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.modifier.myShadow
import com.example.caffeine.ui.theme.AppTheme
import com.example.caffeine.ui.theme.urbanist

@Composable
fun ReadySection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(AppTheme.color.caffeineRoast, shape = CircleShape)
                .myShadow(
                    color = AppTheme.color.caffeineRoast.copy(0.5f),
                    offsetX = 0.dp,
                    offsetY = 2.dp,
                    blurRadius = 8.dp,
                    shape = CircleShape
                )
            ,
            contentAlignment = Alignment.Center
        ) {
            Icon(
                tint = Color(0xDEFFFFFF),
                contentDescription = null,
                imageVector = ImageVector.vectorResource(R.drawable.tick_icon)
            )
        }
        Text(
            "Your coffee is ready,\n Enjoy",
            modifier = Modifier.padding(top = 24.dp),
            fontFamily = urbanist,
            fontWeight = FontWeight(700),
            fontSize = 22.sp,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center
        )
    }

}


@Preview(showBackground = true)
@Composable
private fun PreviewReadySection() {
    ReadySection()
}