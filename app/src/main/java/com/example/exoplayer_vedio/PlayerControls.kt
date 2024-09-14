package com.example.exoplayer_vedio

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
internal fun PlayerControls(
    playResourceProvider: () -> Int,
    onUiEvent: (UIEvent) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(35.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = playResourceProvider()),
            contentDescription = "Play/Pause Button",
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = { onUiEvent(UIEvent.PlayPause) })
                .padding(8.dp)
                .size(56.dp)
        )

    }
}