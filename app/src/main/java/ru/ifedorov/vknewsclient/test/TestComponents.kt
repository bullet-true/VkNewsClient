package ru.ifedorov.vknewsclient.test

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.ifedorov.vknewsclient.ui.theme.VKNewsClientTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TestComponents() {
    VKNewsClientTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Top bar") },
                    navigationIcon = {
                        IconButton(
                            onClick = {},
                        ) {
                            Icon(Icons.Filled.Clear, contentDescription = null)
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = {
                            Icon(Icons.Filled.DateRange, contentDescription = null)
                        },
                        label = { Text("Date") }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(Icons.Filled.Edit, contentDescription = null)
                        },
                        label = { Text("Edit") }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(Icons.Filled.Delete, contentDescription = null)
                        },
                        label = { Text("Delete") }
                    )
                }
            }
        ) { paddingValues ->
            Text(
                modifier = Modifier.padding(paddingValues),
                text = "This is the scaffold content"
            )
        }
    }
}

// делаем расширение, чтобы использовать weight
@Composable
private fun ColumnScope.TestText(
    text: String,
    count: Int
) {
    repeat(count) {
        Text(
            modifier = Modifier.weight(1f),
            text = text
        )
    }
}