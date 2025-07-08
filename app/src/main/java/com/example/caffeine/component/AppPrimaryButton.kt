package com.example.caffeine.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.modifier.myShadow
import com.example.caffeine.ui.theme.AppTheme
import com.example.caffeine.ui.theme.urbanist

@Composable
fun AppPrimaryButton(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.color.caffeineEspresso,
            contentColor = AppTheme.color.caffeineCream
        ),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 18.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
        modifier = modifier.myShadow(
            offsetX = 0.dp,
            offsetY = 5.dp,
            blurRadius = 10.dp,
            color = Color(0x3D000000)
        )

    ) {
        Text(
            title,
            fontFamily = urbanist,
            fontWeight = FontWeight(700),
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .padding(end = 8.dp)
        )
        Icon(
            icon, contentDescription = null, modifier = Modifier.size(24.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewPrimaryButton() {
    AppPrimaryButton(
        title = "bring my coffee",
        icon = ImageVector.vectorResource(R.drawable.coffee_cup),
        onClick = {}
    )
}