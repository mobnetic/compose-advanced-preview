package com.mobnetic.compose.advancedpreview.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp


@Composable
fun CloseButton() {
    IconButton(onClick = {}) {
        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
    }
}

@Composable
fun LoremIpsumText(words: Int) {
    Text(
        text = LoremIpsum(words).values.first(),
        style = MaterialTheme.typography.body1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}