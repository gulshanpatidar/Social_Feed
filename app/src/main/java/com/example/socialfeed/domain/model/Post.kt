package com.example.socialfeed.domain.model

data class Post(
    val type: PostType = PostType.QUESTION,
    val name: String = "",
    val image: String = "",
    var likes: Int = 0,
    var isLiked: Boolean = false,
    val comments: List<Comment> = emptyList(),
    val user: UserProfile = UserProfile()
)