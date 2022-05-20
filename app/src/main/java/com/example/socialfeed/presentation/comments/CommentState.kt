package com.example.socialfeed.presentation.comments

import com.example.socialfeed.domain.model.Post

data class CommentState(
    val post: Post = Post()
)