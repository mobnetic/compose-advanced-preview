package com.mobnetic.compose.advancedpreview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mobnetic.compose.advancedpreview.ui.ContentLayout
import com.mobnetic.compose.advancedpreview.ui.NavigationBarLayout
import com.mobnetic.compose.advancedpreview.ui.StatusBarLayout

@Composable
fun AdvancedPreview(
    device: Device = Device(),
    statusBar: StatusBar = StatusBar.default(),
    navigationBar: NavigationBar = NavigationBar.default(),
    backgroundColor: Color = MaterialTheme.colors.surface,
    time: StatusBarTime = StatusBarTime.Default,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .size(device.screenWidth, device.screenHeight)
            .background(backgroundColor)
    ) {
        StatusBarLayout(device, statusBar, time)

        ContentLayout(device, statusBar, navigationBar, content)

        NavigationBarLayout(
            device,
            navigationBar,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}