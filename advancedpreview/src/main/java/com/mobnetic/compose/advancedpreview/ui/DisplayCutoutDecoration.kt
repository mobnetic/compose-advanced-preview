package com.mobnetic.compose.advancedpreview.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.LayoutDirection
import com.mobnetic.compose.advancedpreview.DisplayCutout

@Composable
internal fun DisplayCutoutDecoration(
    displayCutout: DisplayCutout,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .padding(displayCutout.margin)
            .size(displayCutout.width, displayCutout.height)
            .clip(displayCutout.shape)
            .background(Color.Black)
    )
}

private val DisplayCutout.shape
    get() = when (this) {
        is DisplayCutout.O -> CircleShape
    }

internal val DisplayCutout.takenWidth
    get() = width +
            margin.calculateLeftPadding(LayoutDirection.Ltr) +
            margin.calculateRightPadding(LayoutDirection.Ltr)

internal val DisplayCutout.Position.alignment
    get() = when (this) {
        DisplayCutout.Position.Left -> AbsoluteAlignment.TopLeft
        DisplayCutout.Position.Center -> Alignment.TopCenter
        DisplayCutout.Position.Right -> AbsoluteAlignment.TopRight
    }