package com.mobnetic.compose.advancedpreview.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobnetic.compose.advancedpreview.AdvancedPreview
import com.mobnetic.compose.advancedpreview.Device
import com.mobnetic.compose.advancedpreview.NavigationBar
import com.mobnetic.compose.advancedpreview.NavigationType
import com.mobnetic.compose.advancedpreview.StatusBar
import com.mobnetic.compose.advancedpreview.ui.CloseButton
import com.mobnetic.compose.advancedpreview.ui.LoremIpsumText

@Preview
@Composable
private fun Sample3AdvancedPreview() {
    MaterialTheme {
        AdvancedPreview(
            device = Device(
                statusBarSize = 48.dp,
                navigationType = NavigationType.Gesture()
            ),
            statusBar = StatusBar.default(
                color = Color.Black.copy(alpha = 0.11f),
                darkIcons = true
            ),
            navigationBar = NavigationBar.default(
                color = Color.Transparent,
                darkIcons = true,
                overlaysContent = true
            )
        ) {
            SampleScreen3()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Sample3StandardPreview() {
    MaterialTheme {
        SampleScreen3()
    }
}


@Composable
private fun SampleScreen3() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Title") },
                navigationIcon = { CloseButton() },
                backgroundColor = MaterialTheme.colors.background
            )
        }
    ) {
        Box(Modifier.verticalScroll(state = rememberScrollState())) {
            LoremIpsumText(100)
        }
    }
}