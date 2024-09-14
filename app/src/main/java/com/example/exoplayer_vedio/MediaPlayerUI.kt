package com.example.exoplayer_vedio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SimpleMediaPlayerUI(
    modifier: Modifier = Modifier,

    playResourceProvider: () -> Int,

    onUiEvent: (UIEvent) -> Unit
) {

    Box(
        modifier = modifier
            .padding(16.dp)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
            .background(Color.LightGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PlayerControls(
                playResourceProvider = playResourceProvider,
                onUiEvent = onUiEvent
            )
        }
    }
}