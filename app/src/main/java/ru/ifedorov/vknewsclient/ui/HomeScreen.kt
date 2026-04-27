package ru.ifedorov.vknewsclient.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ifedorov.vknewsclient.MainViewModel

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val feedPosts = viewModel.feedPosts.observeAsState(listOf())

    LazyColumn(
        modifier = modifier.padding(paddingValues),
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = feedPosts.value,
            key = { it.id }
        ) { feedPost ->

            val dismissState = rememberSwipeToDismissBoxState(
                positionalThreshold = { totalDistance ->
                    totalDistance * 0.8f
                },
                confirmValueChange = { value ->
                    if (value == SwipeToDismissBoxValue.EndToStart) {
                        viewModel.remove(feedPost)
                        true
                    } else {
                        false
                    }
                }
            )

            SwipeToDismissBox(
                modifier = Modifier.animateItem(),
                state = dismissState,
                backgroundContent = {},
                enableDismissFromStartToEnd = true
            ) {
                PostCard(
                    feedPost = feedPost,
                    onLikeClick = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onShareClick = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onViewsClick = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onCommentClick = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                )
            }
        }
    }
}