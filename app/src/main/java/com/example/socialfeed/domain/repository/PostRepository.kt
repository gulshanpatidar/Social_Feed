package com.example.socialfeed.domain.repository

import com.example.socialfeed.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    suspend fun getPosts(): Flow<List<Post>>
}