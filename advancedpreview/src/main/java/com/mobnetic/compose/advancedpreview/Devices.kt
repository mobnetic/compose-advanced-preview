package com.mobnetic.compose.advancedpreview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import com.mobnetic.compose.advancedpreview.DisplayCutout.Position

object Devices {

    object Pixel6 {
        const val widthDp = 420
        const val heightDp = 934

        operator fun invoke() = Device(
            screenWidth = widthDp.dp,
            screenHeight = heightDp.dp,
            statusBarSize = 48.dp,
            statusBarContentPadding = PaddingValues(start = 19.dp, top = 1.dp, end = 29.dp),
            displayCutout = DisplayCutout.O(
                size = 25.dp,
                topMargin = 11.5.dp,
                position = Position.Center
            ),
        )
    }

    object Pixel6Pro {
        const val widthDp = 450
        const val heightDp = 975

        operator fun invoke() = Device(
            screenWidth = widthDp.dp,
            screenHeight = heightDp.dp,
            statusBarSize = 45.dp,
            statusBarContentPadding = PaddingValues(start = 25.dp, top = 1.dp, end = 32.dp),
            displayCutout = DisplayCutout.O(
                size = 26.dp,
                topMargin = 9.5.dp,
                position = Position.Center
            ),
        )
    }

    object Pixel5 {
        const val widthDp = 402
        const val heightDp = 871

        operator fun invoke() = Device(
            screenWidth = widthDp.dp,
            screenHeight = heightDp.dp,
            statusBarSize = 54.dp,
            statusBarContentPadding = PaddingValues(start = 16.dp, top = 2.dp, end = 27.dp),
            displayCutout = DisplayCutout.O(
                size = 28.dp,
                leftMargin = 13.dp,
                topMargin = 13.dp,
                position = Position.Left
            ),
        )
    }

    object Pixel4a {
        const val widthDp = 389
        const val heightDp = 843

        operator fun invoke() = Device(
            screenWidth = widthDp.dp,
            screenHeight = heightDp.dp,
            statusBarSize = 49.dp,
            statusBarContentPadding = PaddingValues(start = 16.dp, top = 11.dp, end = 19.dp),
            displayCutout = DisplayCutout.O(
                size = 30.dp,
                leftMargin = 15.dp,
                topMargin = 15.dp,
                position = Position.Left
            ),
        )
    }
}