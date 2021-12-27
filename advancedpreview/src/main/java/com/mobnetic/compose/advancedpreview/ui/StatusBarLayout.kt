package com.mobnetic.compose.advancedpreview.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mobnetic.compose.advancedpreview.Device
import com.mobnetic.compose.advancedpreview.DisplayCutout
import com.mobnetic.compose.advancedpreview.DisplayCutout.Position
import com.mobnetic.compose.advancedpreview.R
import com.mobnetic.compose.advancedpreview.Settings
import com.mobnetic.compose.advancedpreview.StatusBar
import com.mobnetic.compose.advancedpreview.StatusBarTime

@Composable
internal fun StatusBarLayout(
    device: Device,
    settings: Settings,
    statusBar: StatusBar,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(device.statusBarSize)
            .background(statusBar.color)
            .zIndex(100f)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = IconsHorizontalSpace),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .displayCutoutPadding(device.displayCutout)
                .padding(device.statusBarContentPadding),
        ) {
            SystemBarContent(statusBar) {
                StatusBarClock(settings.time, modifier = Modifier.weight(1f))
                StatusBarIcons()
            }
        }

        device.displayCutout?.takeIf { settings.showDisplayCutoutDecoration }?.let { cutout ->
            DisplayCutoutDecoration(cutout, modifier = Modifier.align(cutout.position.alignment))
        }
    }
}

@Composable
private fun StatusBarClock(
    time: StatusBarTime,
    modifier: Modifier,
) {
    Text(
        text = time.format(),
        modifier = modifier,
        style = ClockTextStyle
    )
}

@Composable
private fun StatusBarIcons() {
    StatusBarIcon(R.drawable.ap_ic_status_bar_wifi)
    StatusBarIcon(R.drawable.ap_ic_status_bar_cellular)
    StatusBarIcon(R.drawable.ap_ic_status_bar_battery, increaseSizeBy = 1.dp)
}

@Composable
private fun StatusBarIcon(@DrawableRes iconResId: Int, increaseSizeBy: Dp = 0.dp) {
    Icon(
        painter = painterResource(id = iconResId),
        contentDescription = "",
        modifier = Modifier
            .size(IconSize + increaseSizeBy)
            .autoMirror()
    )
}

private fun StatusBarTime.format() = String.format("%02d:%02d", hours, minutes)

private fun Modifier.displayCutoutPadding(cutout: DisplayCutout?) = this.then(
    when (cutout?.position) {
        Position.Left -> Modifier.absolutePadding(left = cutout.takenWidth)
        Position.Right -> Modifier.absolutePadding(right = cutout.takenWidth)
        else -> Modifier
    }
)

private val IconsHorizontalSpace = 1.dp
private val IconSize = 15.dp
private val ClockTextStyle = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    letterSpacing = 0.4.sp,
)