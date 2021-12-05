package com.mobnetic.compose.advancedpreview.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mobnetic.compose.advancedpreview.Device
import com.mobnetic.compose.advancedpreview.NavigationBar
import com.mobnetic.compose.advancedpreview.NavigationType
import com.mobnetic.compose.advancedpreview.NavigationType.Gesture
import com.mobnetic.compose.advancedpreview.NavigationType.ThreeButtons
import com.mobnetic.compose.advancedpreview.R

@Composable
internal fun NavigationBarLayout(
    device: Device,
    navigationBar: NavigationBar,
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(device.navigationType.size)
            .background(navigationBar.color)
            .padding(horizontal = PaddingHorizontal)
            .zIndex(100f)
    ) {
        SystemBarContent(navigationBar) {
            device.navigationType.Content()
        }
    }
}

@Composable
private fun NavigationType.Content() = when (this) {
    is ThreeButtons -> NavigationBarThreeButtonsIcons()
    is Gesture -> NavigationBarGestureHandle()
}

@Composable
private fun NavigationBarThreeButtonsIcons() {
    NavigationBarIcon(R.drawable.ap_ic_navigation_bar_back)
    NavigationBarIcon(R.drawable.ap_ic_navigation_bar_home, increaseSizeBy = 4.dp)
    NavigationBarIcon(R.drawable.ap_ic_navigation_bar_recent)
}

@Composable
private fun NavigationBarGestureHandle() {
    val color = LocalContentColor.current.copy(LocalContentAlpha.current)
    Box(
        modifier = Modifier
            .size(width = 72.dp, height = 2.dp)
            .clip(shape = RoundedCornerShape(50))
            .background(color)
    )
}

@Composable
private fun NavigationBarIcon(@DrawableRes iconResId: Int, increaseSizeBy: Dp = 0.dp) {
    Icon(
        painter = painterResource(id = iconResId),
        contentDescription = "",
        modifier = Modifier
            .size(IconsSize + increaseSizeBy)
            .autoMirror()
    )
}

private val IconsSize = 28.dp
private val PaddingHorizontal = 24.dp