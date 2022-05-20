package com.example.socialfeed.data

import com.example.socialfeed.domain.model.Post
import com.example.socialfeed.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(): PostRepository{

    override suspend fun getPosts(): Flow<List<Post>> {
        return flow {
            emit(PostData.posts)
        }
    }
}