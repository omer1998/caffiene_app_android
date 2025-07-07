package com.example.caffeine.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.AppTheme

@Composable
fun CircularButton(onClick: () -> Unit, image: Painter, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = image, contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun CircularButton(onClick: () -> Unit, icon: ImageVector, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(color = AppTheme.color.caffeineCream)
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .size(24.dp),
            tint = AppTheme.color.caffeineEspresso
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewButton() {
    CircularButton(
        onClick = {},
        image = painterResource(R.drawable.ghost_with_coffee)
    )
}