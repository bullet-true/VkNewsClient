package ru.ifedorov.vknewsclient.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.ifedorov.vknewsclient.MainViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val selectedNavItem by viewModel.selectedNavItem.observeAsState(NavigationItem.Home)

    Scaffold(
        bottomBar = {
            NavigationBar() {

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favorite,
                    NavigationItem.Profile
                )

                items.forEach { item ->
                    NavigationBarItem(
                        selected = selectedNavItem == item,
                        onClick = {
                            viewModel.selectNavItem(item)
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
        when (selectedNavItem) {
            NavigationItem.Home -> {
                HomeScreen(viewModel = viewModel, paddingValues = paddingValues)
            }

            NavigationItem.Favorite -> {
                TextCounter("Favorite")
            }

            NavigationItem.Profile -> {
                TextCounter("Profile")
            }
        }
    }
}

@Composable
private fun TextCounter(name: String) {
    var count by remember {
        mutableIntStateOf(0)
    }

    Text(
        modifier = Modifier
            .clickable {
                count++
            }
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        text = "$name  Count: $count"
    )
}