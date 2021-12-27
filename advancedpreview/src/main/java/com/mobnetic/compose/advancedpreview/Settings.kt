package com.mobnetic.compose.advancedpreview

data class Settings(
    val time: StatusBarTime = StatusBarTime.Default,
    val showDisplayCutoutDecoration: Boolean = false,
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