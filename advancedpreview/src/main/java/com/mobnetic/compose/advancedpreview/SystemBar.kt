package com.mobnetic.compose.advancedpreview

import androidx.compose.ui.graphics.Color

internal interface SystemBar {
    val color: Color
    val overlaysContent: Boolean
    val darkIcons: Boolean
}