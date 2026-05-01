package ru.ifedorov.vknewsclient.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import ru.ifedorov.vknewsclient.MainViewModel
import ru.ifedorov.vknewsclient.domain.PostComment

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val feedPosts = viewModel.feedPosts.observeAsState(listOf())

    val comments = mutableListOf<PostComment>().apply {
        repeat(20) {
            add(PostComment(id = it))
        }
    }
    CommentsScreen(
        feedPost = feedPosts.value.first(),
        comments = comments,
    )
//    LazyColumn(
//        modifier = modifier.padding(paddingValues),
//        contentPadding = PaddingValues(
//            top = 16.dp,
//            start = 8.dp,
//            end = 8.dp,
//            bottom = 16.dp
//        ),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(
//            items = feedPosts.value,
//            key = { it.id }
//        ) { feedPost ->
//
//            val dismissState = rememberSwipeToDismissBoxState(
//                positionalThreshold = { totalDistance ->
//                    totalDistance * 0.8f
//                },
//                confirmValueChange = { value ->
//                    if (value == SwipeToDismissBoxValue.EndToStart) {
//                        viewModel.remove(feedPost)
//                        true
//                    } else {
//                        false
//                    }
//                }
//            )
//
//            SwipeToDismissBox(
//                modifier = Modifier.animateItem(),
//                state = dismissState,
//                backgroundContent = {},
//                enableDismissFromStartToEnd = true
//            ) {
//                PostCard(
//                    feedPost = feedPost,
//                    onLikeClick = { statisticItem ->
//                        viewModel.updateCount(feedPost, statisticItem)
//                    },
//                    onShareClick = { statisticItem ->
//                        viewModel.updateCount(feedPost, statisticItem)
//                    },
//                    onViewsClick = { statisticItem ->
//                        viewModel.updateCount(feedPost, statisticItem)
//                    },
//                    onCommentClick = { statisticItem ->
//                        viewModel.updateCount(feedPost, statisticItem)
//                    },
//                )
//            }
//        }
//    }
}