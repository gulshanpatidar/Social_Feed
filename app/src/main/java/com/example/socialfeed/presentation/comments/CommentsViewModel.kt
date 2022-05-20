package com.example.socialfeed.presentation.comments

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialfeed.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val repository: PostRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var state by mutableStateOf(CommentState())

    init {
        viewModelScope.launch {
            val index = savedStateHandle.get<Int>("index") ?: return@launch
            repository
                .getPosts()
                .collect{ result ->
                    val post = result[index]
                    state = state.copy(
                        post = post
                    )
                }
        }
    }
}