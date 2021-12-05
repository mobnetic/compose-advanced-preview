package com.mobnetic.compose.advancedpreview.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import com.google.accompanist.insets.Insets
import com.google.accompanist.insets.Insets.Companion.Insets
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.WindowInsets
import com.mobnetic.compose.advancedpreview.Device

@Composable
internal fun ProvideWindowInsets(device: Device, content: @Composable () -> Unit) {
    val insets = calculateWindowInsets(device)
    CompositionLocalProvider(LocalWindowInsets provides insets, content = content)
}

@Composable
private fun calculateWindowInsets(device: Device) = with(LocalDensity.current) {
    WindowInsets.Empty.copy(
        statusBars = StaticWindowInsetsType(
            Insets(top = device.statusBarSize.roundToPx())
        ),
        navigationBars = StaticWindowInsetsType(
            Insets(bottom = device.navigationType.size.roundToPx())
        )
    )
}

private class StaticWindowInsetsType(
    override val layoutInsets: Insets
) : WindowInsets.Type {
    override val animatedInsets: Insets = Insets.Empty
    override val isVisible: Boolean = true
    override val animationInProgress: Boolean = false
    override val animationFraction: Float = 0f
}