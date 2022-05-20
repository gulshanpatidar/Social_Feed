package com.example.socialfeed.presentation.home

sealed class HomeEvent {
    object Refresh: HomeEvent()
    object OnClickLikeButton: HomeEvent()
}