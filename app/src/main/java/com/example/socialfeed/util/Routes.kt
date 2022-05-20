package com.example.socialfeed.util

sealed class Routes(val route: String) {

    object Home: Routes("home_screen")
    object Comment: Routes("comment_screen")
}