package com.mobnetic.compose.advancedpreview

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

data class StatusBar(
    override val color: Color,
    override val overlaysContent: Boolean = false,
    override val darkIcons: Boolean = color.luminance() > 0.5f,
) : SystemBar {

    companion object {

        @Composable
        fun default(
            color: Color = MaterialTheme.colors.primaryVariant,
            overlaysContent: Boolean = false,
            darkIcons: Boolean = color.luminance() > 0.5f,
        ) = StatusBar(
            color,
            overlaysContent,
            darkIcons,
        )
    }
}

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