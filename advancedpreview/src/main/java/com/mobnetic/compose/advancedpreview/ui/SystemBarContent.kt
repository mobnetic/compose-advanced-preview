package com.mobnetic.compose.advancedpreview.ui

import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.mobnetic.compose.advancedpreview.SystemBar

@Composable
internal fun SystemBarContent(systemBar: SystemBar, content: @Composable () -> Unit) {
    val contentColor = if (systemBar.darkIcons) ContentColorDark else ContentColorLight
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
        LocalContentAlpha provides 1f,
        content = content
    )
}

internal fun Modifier.autoMirror() = composed {
    val rotationY = if (LocalLayoutDirection.current == LayoutDirection.Rtl) 180f else 0f
    Modifier.graphicsLayer(rotationY = rotationY)
}

private val ContentColorLight = Color(0xFFF2F2F2)
private val ContentColorDark = Color(0xFF424242)