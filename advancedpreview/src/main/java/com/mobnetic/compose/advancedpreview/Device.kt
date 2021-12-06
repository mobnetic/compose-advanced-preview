package com.mobnetic.compose.advancedpreview

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Device(
    val screenWidth: Dp = DefaultScreenWidth,
    val screenHeight: Dp = DefaultScreenHeight,
    val statusBarSize: Dp = DefaultStatusBarSize,
    val navigationType: NavigationType = NavigationType.ThreeButtons()
)

sealed class NavigationType(val size: Dp) {
    class ThreeButtons : NavigationType(size = DefaultNavigationBarSizeThreeButtons)
    class Gesture : NavigationType(size = DefaultNavigationBarSizeGesture)
}

private val DefaultScreenWidth = 403.dp
private val DefaultScreenHeight = 874.dp

private val DefaultStatusBarSize = 24.dp

private val DefaultNavigationBarSizeThreeButtons = 48.dp
private val DefaultNavigationBarSizeGesture = 16.dp