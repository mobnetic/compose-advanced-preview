package com.mobnetic.compose.advancedpreview.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.mobnetic.compose.advancedpreview.AdvancedPreview
import com.mobnetic.compose.advancedpreview.NavigationBar
import com.mobnetic.compose.advancedpreview.StatusBar
import com.mobnetic.compose.advancedpreview.ui.CloseButton
import com.mobnetic.compose.advancedpreview.ui.LoremIpsumText

@Preview
@Composable
private fun Sample2AdvancedPreview() {
    val systemBarsColor = Color.Black.copy(alpha = 0.3f)
    MaterialTheme {
        AdvancedPreview(
            statusBar = StatusBar.default(
                color = systemBarsColor,
                overlaysContent = true
            ),
            navigationBar = NavigationBar.default(
                color = systemBarsColor,
                overlaysContent = true
            )
        ) {
            SampleScreen2()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Sample2StandardPreview() {
    MaterialTheme {
        SampleScreen2()
    }
}

@Composable
private fun SampleScreen2() {
    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
            .navigationBarsPadding()
    ) {
        Box {
            Image(painterResource(id = R.drawable.header_wallpaper), contentDescription = "")

            TopAppBar(
                title = { Text("Title") },
                navigationIcon = { CloseButton() },
                backgroundColor = Color.Black.copy(alpha = 0.15f),
                contentColor = Color.White,
                elevation = 0.dp,
                modifier = Modifier.statusBarsPadding()
            )
        }
        LoremIpsumText(250)
    }
}