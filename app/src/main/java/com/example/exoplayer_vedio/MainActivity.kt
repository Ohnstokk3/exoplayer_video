package com.example.exoplayer_vedio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exoplayer_vedio.ui.theme.Exoplayer_vedioTheme

class MainActivity : ComponentActivity() {
    private val viewModel: SimpleMediaViewModel by viewModels()
    private var isServiceRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Destination.Main.route) {
                composable(Destination.Main.route) {
                    SimpleMediaScreen(
                        vm = viewModel,
                        navController = navController,
                        startService = ::startService
                    )
                }

            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this, MediaService::class.java))
        isServiceRunning = false
    }
    private fun startService() {
        if (!isServiceRunning) {
            val intent = Intent(this, MediaService::class.java)
            startForegroundService(intent)
            isServiceRunning = true
        }
    }
}
