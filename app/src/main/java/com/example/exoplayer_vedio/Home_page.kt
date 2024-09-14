package com.example.exoplayer_vedio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController


@Composable
internal fun SimpleMediaScreen(
    vm: SimpleMediaViewModel,
    navController: NavController,
    startService: () -> Unit,
) {
    val state = vm.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        when (state.value) {
            UIState.Initial -> CircularProgressIndicator(
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center)
            )
            is UIState.Ready -> {
                LaunchedEffect(true) { // This is only call first time
                    startService()
                }

                ReadyContent(vm = vm, navController = navController)
            }
        }

    }
}

@Composable
private fun ReadyContent(
    vm: SimpleMediaViewModel,
    navController: NavController,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SimpleMediaPlayerUI(

            playResourceProvider = {
                if (vm.isPlaying) android.R.drawable.ic_media_pause
                else android.R.drawable.ic_media_play
            },

            onUiEvent = vm::onUIEvent,
        )

    }
}