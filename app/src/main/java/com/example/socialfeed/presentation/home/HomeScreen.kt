package com.example.socialfeed.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Reply
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.socialfeed.R
import com.example.socialfeed.domain.model.PostType
import com.example.socialfeed.presentation.destinations.CommentScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    val state = viewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Charcha")
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            itemsIndexed(state.posts) { index,post ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(post.user.userImage)
                                .crossfade(true)
                                .build(),
                            contentDescription = "User Image",
                            placeholder = painterResource(id = R.drawable.user_image_placeholder),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(45.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = post.user.username,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "2 hours ago",
                                fontWeight = FontWeight.Light,
                                fontSize = 10.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Surface(
                            color = Color(0xFFF1f5FF)
                        ) {
                            Text(
                                text = post.type.toString(),
                                color = Color(0xff416fe5),
                                fontSize = 12.sp,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(32.dp))
                        Icon(
                            imageVector = Icons.Default.MoreHoriz,
                            contentDescription = "More options icon",
                            modifier = Modifier.align(CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = post.name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    if (post.type == PostType.MARKETING) {
                        Spacer(modifier = Modifier.height(8.dp))
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(post.image)
                                .crossfade(true)
                                .build(),
                            contentDescription = "Post Image",
                            placeholder = painterResource(id = R.drawable.user_image_placeholder),
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = "Like button",
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${post.likes} likes",
                                fontSize = 12.sp
                            )
                        }
                        Row(
                            modifier = Modifier.clickable {
                                navigator.navigate(CommentScreenDestination(index))
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ChatBubbleOutline,
                                contentDescription = "Comment icon"
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${post.comments.size} comments",
                                fontSize = 12.sp
                            )
                        }
                        Row {
                            Icon(
                                imageVector = Icons.Default.Reply,
                                contentDescription = "Share Icon"
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "share",
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}