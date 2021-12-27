package com.mobnetic.compose.advancedpreview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Device(
    val screenWidth: Dp = DefaultScreenWidth,
    val screenHeight: Dp = DefaultScreenHeight,
    val statusBarSize: Dp = DefaultStatusBarSize,
    val statusBarContentPadding: PaddingValues = PaddingValues(
        start = DefaultStatusBarContentPaddingStart,
        end = DefaultStatusBarContentPaddingEnd
    ),
    val displayCutout: DisplayCutout? = null,
    val navigationType: NavigationType = NavigationType.ThreeButtons()
)

sealed class NavigationType(val size: Dp) {
    class ThreeButtons : NavigationType(size = DefaultNavigationBarSizeThreeButtons)
    class Gesture : NavigationType(size = DefaultNavigationBarSizeGesture)
}

sealed class DisplayCutout(
    val width: Dp,
    val height: Dp,
    val margin: PaddingValues.Absolute,
    val position: Position,
) {

    class O(
        size: Dp,
        topMargin: Dp,
        leftMargin: Dp = 0.dp,
        rightMargin: Dp = 0.dp,
        position: Position = Position.Center
    ) : DisplayCutout(
        width = size,
        height = size,
        margin = PaddingValues.Absolute(left = leftMargin, top = topMargin, right = rightMargin),
        position = position
    )

    enum class Position { Left, Center, Right }
}

private val DefaultScreenWidth = 403.dp
private val DefaultScreenHeight = 874.dp

private val DefaultStatusBarSize = 24.dp

private val DefaultStatusBarContentPaddingStart = 8.dp
private val DefaultStatusBarContentPaddingEnd = 4.dp

private val DefaultNavigationBarSizeThreeButtons = 48.dp
private val DefaultNavigationBarSizeGesture = 16.dp