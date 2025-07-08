package com.example.caffeine.screen.drinkDetail.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.screen.drinkDetail.CupSize
import com.example.caffeine.ui.theme.AppTheme
import com.example.caffeine.ui.theme.urbanist

@Composable
fun CupSizeOption(
    modifier: Modifier = Modifier,
    currentSize: CupSize = CupSize.M,
    onClick: (cupSize: CupSize) -> Unit,
) {
    Row(
        modifier = modifier
            .background(
                color = Color(0xFFF5F5F5), shape = RoundedCornerShape(
                    100.dp
                )
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val interactionSource = remember {
            MutableInteractionSource()
        }
        CupSize.entries.forEach {
            val isSelected = it == currentSize
            val shadowRadius by animateDpAsState(
                targetValue = if (isSelected) 4.dp else 0.dp,
                label = "shadow animation"
            )
            val textColor by animateColorAsState(
                targetValue = if (isSelected) Color(0xDEFFFFFF) else Color(0x991F1F1F),
                label = "text color animation",
                animationSpec = TweenSpec(
                    durationMillis = 300
                )
            )

            val shapeColor by animateColorAsState(
                targetValue = if (isSelected) AppTheme.color.caffeineRoast else Color.Transparent,
                label = "shape color animation",
                animationSpec = TweenSpec(
                    durationMillis = 300
                )
            )
            val sidePadding = Modifier.padding(
                        start = if (it.ordinal == 0) 8.dp else 0.dp,
                        end = if (it.ordinal == CupSize.entries.lastIndex) 8.dp else 0.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )

            Box(
                contentAlignment = Alignment.Center,
                modifier = sidePadding
                    .shadow(
                        shadowRadius,                   
                        shape = CircleShape,            
                        ambientColor = Color(0x80B94B23)
                    )                                   
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        shape = CircleShape,
                        color = shapeColor
                    )
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        onClick(it)
                    }
                    
                    
                    
                    
                    


            ) {
                Text(
                    text = it.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = urbanist,
                    color = textColor
                )
            }
        }
    }
}


@Preview(backgroundColor = 0xFF111010)
@Composable
private fun PreviewCupSizeOption() {
    var selectedSize by remember { mutableStateOf(CupSize.M) }
    CupSizeOption(
        currentSize = selectedSize,
        onClick = {
            selectedSize = it
        }
    )
}