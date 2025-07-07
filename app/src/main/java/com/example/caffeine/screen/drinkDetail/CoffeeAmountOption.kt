package com.example.caffeine.screen.drinkDetail

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.AppTheme

@Composable
fun CoffeeAmountOption(
    onClick: (coffeeAmount: CoffeeAmount) -> Unit,
    modifier: Modifier = Modifier,
    currentCoffeeAmount: CoffeeAmount = CoffeeAmount.MEDIUM,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
        .widthIn(
            min = 152.dp,
            max = 156.dp
        )
        .wrapContentWidth()) {
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
            CoffeeAmount.entries.forEach {
                val isSelected = it == currentCoffeeAmount
                val shadowRadius by animateDpAsState(
                    targetValue = if (isSelected) 4.dp else 0.dp,
                    label = "shadow animation"
                )
                val iconColor by animateColorAsState(
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
                        .size(40.dp)
                        .shadow(
                            shadowRadius,
                            shape = CircleShape,
                            ambientColor = Color(0x80B94B23)
                        )
                        .clip(CircleShape)
                        .background(
                            shape = CircleShape,
                            color = shapeColor
                        )
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            println("clicked $it")
                            onClick(it)
                        }

                ) {
                    if (isSelected) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.coffee_bean),
                            contentDescription = null,
                            tint = iconColor
                        )
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp)
        ) {
            CoffeeAmount.entries.forEach {
                Text(
                    it.name,
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    letterSpacing = 0.25.sp,
                    color = Color(0x991F1F1F)
                )
            }
        }
    }

}


@Preview(backgroundColor = 0xFFB2B2B2, showBackground = true)
@Composable
private fun PreviewCoffeeAmountOption() {
    var coffeeAmount by remember { mutableStateOf(CoffeeAmount.HIGH) }
    CoffeeAmountOption(
        onClick = {
            coffeeAmount = it
        },
        currentCoffeeAmount = coffeeAmount
    )
}