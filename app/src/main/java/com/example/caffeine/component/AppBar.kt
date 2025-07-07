package com.example.caffeine.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    leading : @Composable () -> Unit,
    title : @Composable ((modifier: Modifier) -> Unit)? = null,
    actions : (@Composable () -> Unit)? = null ,
    ) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        leading()
        title.let{
            title?.invoke(modifier.padding(start=12.dp).weight(1f))
        }
        Spacer(modifier = Modifier.weight(1f))
        actions.let {
            actions?.invoke()
        }
    }
}