package com.mobnetic.compose.advancedpreview.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.mobnetic.compose.advancedpreview.R
import com.mobnetic.compose.advancedpreview.StatusBar
import com.mobnetic.compose.advancedpreview.StatusBarTime

@Composable
internal fun StatusBarLayout(
    device: Device,
    statusBar: StatusBar,
    time: StatusBarTime,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(IconsHorizontalSpace),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(device.statusBarSize)
            .background(statusBar.color)
            .zIndex(100f)
            .padding(start = PaddingStart, end = PaddingEnd)
    ) {
        SystemBarContent(statusBar) {
            StatusBarClock(time, modifier = Modifier.weight(1f))
            StatusBarIcons()
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

private val PaddingStart = 8.dp
private val PaddingEnd = 4.dp
private val IconsHorizontalSpace = 1.dp
private val IconSize = 15.dp
private val ClockTextStyle = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    letterSpacing = 0.4.sp,
)