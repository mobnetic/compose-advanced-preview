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