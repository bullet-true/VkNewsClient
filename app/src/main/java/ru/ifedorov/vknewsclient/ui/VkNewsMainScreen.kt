package ru.ifedorov.vknewsclient.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.ifedorov.vknewsclient.MainViewModel
import ru.ifedorov.vknewsclient.domain.FeedPost

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val feedPost = viewModel.feedPost.observeAsState(FeedPost())

    Scaffold(
        bottomBar = {
            NavigationBar() {
                var selectedItemPosition by remember { mutableIntStateOf(0) }

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favorite,
                    NavigationItem.Profile
                )

                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemPosition == index,
                        onClick = {
                            selectedItemPosition = index
                        },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(item.titleResId))
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        PostCard(
            modifier = modifier
                .padding(paddingValues)
                .padding(8.dp),
            feedPost = feedPost.value,
            onLikeClick = viewModel::updateCount,
            onShareClick = {
                viewModel.updateCount(it)
            },
            onViewsClick = {
                viewModel.updateCount(it)
            },
            onCommentClick = {
                viewModel.updateCount(it)
            },
        )
    }
}