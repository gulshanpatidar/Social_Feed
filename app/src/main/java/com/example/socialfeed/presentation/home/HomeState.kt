package com.example.socialfeed.presentation.home

import com.example.socialfeed.domain.model.Post

data class HomeState(
    val posts: List<Post> = emptyList()
)