package com.example.socialfeed.domain.model

data class Comment(
    val user: UserProfile,
    val text: String,
    val likes: Int
)