package com.example.caffeine.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.caffeine.R
import com.example.caffeine.ui.theme.AppTheme
import com.example.caffeine.ui.theme.urbanist

@Composable
fun AppSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    width: Dp = 80.dp,
    height: Dp = 40.dp,
    thumbSize: Dp = 40.dp,
    onColor: Color,
    offColor: Color,
    thumb: (@Composable () -> Unit)? = null
) {
    val transition = updateTransition(targetState = checked, label = "SwitchTransition")

    val switchColor = transition.animateColor(
        label = "TrackColor",
        transitionSpec = {
            TweenSpec(durationMillis = 300)
        }
    ) {
        if (it) onColor else offColor
    }

    val thumbOffset = transition.animateDp(
        label = "ThumbOffset",
        transitionSpec = {
            TweenSpec(durationMillis = 300)
        }
    ) { state ->
        if (!state) width - thumbSize - 1.5.dp else 1.5.dp
    }

    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .width(width)
            .height(height)
            .clip(CircleShape)
            .background(color = switchColor.value)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onCheckedChange(!checked) },
        contentAlignment = Alignment.CenterStart
    ) {
        if (thumb == null) {
            Box(
                modifier
                    .size(thumbSize)
                    .offset(x = thumbOffset.value)
                    .clip(CircleShape)
                    .zIndex(3f)
                    .padding(
                        top = 1.1.dp,
                        bottom = 1.1.dp,
                        start = 1.1.dp
                    )
            ) {
                Image(
                    contentDescription = null,
                    painter = painterResource(R.drawable.coffee_cup_component)
                )
            }
        }else {
            thumb()
        }
        Text(
            "ON",
            fontSize = 10.sp,
            color = Color(0x99FFFFFF),
            fontFamily = urbanist,
            modifier = Modifier
                .padding(14.dp)
                .align(Alignment.CenterEnd)
        )
        Text(
            "OFF",
            fontSize = 10.sp,
            color = Color(0x99000000),
            fontFamily = urbanist,
            modifier = Modifier
                .padding(14.dp)
                .align(Alignment.CenterStart)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewAppSwitch() {
    var checked by remember { mutableStateOf(true) }
    AppSwitch(
        checked = checked,
        onCheckedChange = { checked = it },
        onColor = AppTheme.color.caffeineRoast,
        offColor = Color(0xFFFFEEE7)
    )
}
