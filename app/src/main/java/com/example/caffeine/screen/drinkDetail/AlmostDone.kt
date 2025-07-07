package com.example.caffeine.screen.drinkDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.urbanist

@Composable
fun AlmostDoneSection(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Almost Done",
            fontSize = 22.sp,
            fontFamily = urbanist,
            fontWeight = FontWeight(700),
            letterSpacing = 0.25.sp,
            lineHeight = 22.sp
        )
        Text(
            "Your coffee will be finish in",
            fontSize = 16.sp,
            fontFamily = urbanist,
            fontWeight = FontWeight(700),
            letterSpacing = 0.25.sp,
            lineHeight = 16.sp,
            color = Color(0x991F1F1F),
            modifier = Modifier.padding(top = 8.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.coffee_mark),
            modifier = Modifier.padding(top = 12.dp),
            contentDescription = null,
            tint = Color(0xFF7C351B)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAlmostDone() {
    AlmostDoneSection()
}