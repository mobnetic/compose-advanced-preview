package com.mobnetic.compose.advancedpreview

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Settings(
    val time: StatusBarTime = StatusBarTime.Default,
    val showDisplayCutoutDecoration: Boolean = false,
    val navigationType: NavigationType = NavigationType.ThreeButtons()
)

@JvmInline
value class StatusBarTime internal constructor(private val secondsOfDay: Int) {

    internal val hours get() = secondsOfDay / 3600
    internal val minutes get() = (secondsOfDay / 60) % 60

    companion object {
        val Default = StatusBarTime(12, 0)
    }
}

fun StatusBarTime(hours: Int, minutes: Int): StatusBarTime {
    require(hours in 0..23) { "Hours should be in 0..23" }
    require(minutes in 0..59) { "Minutes should be in 0..59" }
    return StatusBarTime(secondsOfDay = hours * 3600 + minutes * 60)
}

sealed class NavigationType(val size: Dp) {
    class ThreeButtons : NavigationType(size = DefaultNavigationBarSizeThreeButtons)
    class Gesture : NavigationType(size = DefaultNavigationBarSizeGesture)
}

private val DefaultNavigationBarSizeThreeButtons = 48.dp
private val DefaultNavigationBarSizeGesture = 16.dp