package com.moataz.kotrin.features.imageView

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage

@Composable
fun ImageScreen(
    objectUrl: String
) {
    AsyncImage(
        model = objectUrl,
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
    )
}