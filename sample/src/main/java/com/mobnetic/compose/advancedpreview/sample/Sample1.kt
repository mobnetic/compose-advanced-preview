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
import androidx.compose.ui.tooling.preview.Preview
import com.mobnetic.compose.advancedpreview.AdvancedPreview
import com.mobnetic.compose.advancedpreview.ui.CloseButton
import com.mobnetic.compose.advancedpreview.ui.LoremIpsumText

@Preview
@Composable
private fun Sample1AdvancedPreview() {
    MaterialTheme {
        AdvancedPreview {
            SampleScreen1()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Sample1StandardPreview() {
    MaterialTheme {
        SampleScreen1()
    }
}

@Composable
private fun SampleScreen1() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Title") },
                navigationIcon = { CloseButton() }
            )
        }
    ) {
        Box(Modifier.verticalScroll(state = rememberScrollState())) {
            LoremIpsumText(220)
        }
    }
}