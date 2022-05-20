package com.example.socialfeed.presentation.comments

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun CommentScreen(
    navigator: DestinationsNavigator,
    index: Int,
    viewModel: CommentsViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Comments")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back to home screen",
                        modifier = Modifier
                            .clickable {
                                navigator.navigateUp()
                            }
                            .padding(8.dp)
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            val post = viewModel.state.post

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
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = post.name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
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
                            .height(300.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${post.comments.size} Comments",
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                    Row {
                        Icon(
                            imageVector = Icons.Default.Sort,
                            contentDescription = "Sort by",
                            tint = Color.Blue
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Recent",
                            color = Color.Blue,
                            fontSize = 12.sp,
                            modifier = Modifier.clickable {

                            }
                        )
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(post.comments) { comment ->
                        Spacer(modifier = Modifier.height(16.dp))
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(comment.user.userImage)
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
                                        text = comment.user.username,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Public",
                                        fontWeight = FontWeight.Light,
                                        fontSize = 10.sp
                                    )
                                }
                                Spacer(modifier = Modifier.width(102.dp))
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "More options icon",
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = comment.text,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Divider()
                    }
                }
            }
        }
    }
}