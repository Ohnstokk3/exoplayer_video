package com.example.exoplayer_vedio

sealed class Destination(val route: String) {
    object Main: Destination("main")
    object Secondary: Destination("secondary")
}