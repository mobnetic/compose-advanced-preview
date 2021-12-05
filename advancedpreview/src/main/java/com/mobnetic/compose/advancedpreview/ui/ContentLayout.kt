package com.mobnetic.compose.advancedpreview.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mobnetic.compose.advancedpreview.Device
import com.mobnetic.compose.advancedpreview.NavigationBar
import com.mobnetic.compose.advancedpreview.StatusBar
import com.mobnetic.compose.advancedpreview.SystemBar

@Composable
internal fun ContentLayout(
    device: Device,
    statusBar: StatusBar,
    navigationBar: NavigationBar,
    content: @Composable () -> Unit
) {
    val contentPadding = PaddingValues(
        top = statusBar.getContentPadding(device.statusBarSize),
        bottom = navigationBar.getContentPadding(device.navigationType.size)
    )
    Box(modifier = Modifier.padding(contentPadding)) {
        ProvideWindowInsets(device, content = content)
    }
}

private fun SystemBar.getContentPadding(size: Dp) = if (overlaysContent) 0.dp else size