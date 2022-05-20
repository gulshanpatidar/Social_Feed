package com.example.socialfeed.data

import com.example.socialfeed.domain.model.Comment
import com.example.socialfeed.domain.model.Post
import com.example.socialfeed.domain.model.PostType
import com.example.socialfeed.domain.model.UserProfile

object PostData {

    val userImageLink =
        "https://avatars.githubusercontent.com/u/68196125?s=400&u=c3607d5f60050c4f0b950bbbd2f83197fd4303b4&v=4"
    val postImageLink1 =
        "https://images.unsplash.com/photo-1652082199711-d1b12e4610aa?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764"
    val postImageLink2 =
        "https://images.unsplash.com/photo-1652990367754-7660894449ec?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627"

    val comments = listOf(
        Comment(
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            text = "This is very nice pic",
            likes = 0
        ),
        Comment(
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            text = "your thoughts are awesome",
            likes = 0
        ),
        Comment(
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            text = "Very true",
            likes = 0
        ),
        Comment(
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            text = "When is your next trip?",
            likes = 0
        ),
        Comment(
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            text = "So excited to see you back",
            likes = 0
        ),
        Comment(
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            text = "when are you coming home buddy?",
            likes = 0
        ),
        Comment(
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            text = "My friend is Gaurav",
            likes = 0
        ),
        Comment(
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            text = "I need some water supply",
            likes = 0
        ),
        Comment(
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            text = "This is new record of heat",
            likes = 0
        )
    )

    val posts = listOf(
        Post(
            PostType.QUESTION,
            "what is up everybody ?",
            "",
            2,
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            comments = comments
        ),
        Post(
            PostType.QUESTION,
            "I am on the moon",
            "",
            1,
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            comments = comments
        ),
        Post(
            PostType.MARKETING,
            "See this is an amazing photo",
            postImageLink1,
            42,
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            comments = comments
        ),
        Post(
            PostType.QUESTION,
            "how are you doing",
            "",
            73,
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            comments = comments
        ),
        Post(
            PostType.QUESTION,
            "android dev is lob",
            "",
            32,
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            comments = comments
        ),
        Post(
            PostType.MARKETING,
            "again seeing this",
            postImageLink2,
            5,
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            comments = comments
        ),
        Post(
            PostType.QUESTION,
            "nothing is permanent",
            "",
            222,
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            comments = comments
        ),
        Post(
            PostType.QUESTION,
            "There is too much heat here",
            "",
            27,
            user = UserProfile(username = "Gulshan Patidar", userImage = userImageLink),
            comments = comments
        ),
    )
}