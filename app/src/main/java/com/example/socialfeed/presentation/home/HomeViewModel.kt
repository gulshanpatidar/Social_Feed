package com.example.socialfeed.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialfeed.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    var state by mutableStateOf(HomeState())

    init {
        getPosts()
    }

//    fun onEvent(event: HomeEvent){
//        when(event){
//            is HomeEvent.Refresh ->{
//                getPosts()
//            }
//            is HomeEvent.OnClickLikeButton ->{
//                state = state.copy(
//
//                )
//            }
//        }
//    }

    private fun getPosts(){
        viewModelScope.launch {
            repository
                .getPosts()
                .collect{ result ->
                    state = state.copy(posts = result)
                }
        }
    }
}