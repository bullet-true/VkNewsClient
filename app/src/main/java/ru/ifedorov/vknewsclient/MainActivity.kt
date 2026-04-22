package ru.ifedorov.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import ru.ifedorov.vknewsclient.ui.MainScreen
import ru.ifedorov.vknewsclient.ui.theme.VKNewsClientTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKNewsClientTheme {
                MainScreen(
                    modifier = Modifier.fillMaxWidth(),
                    viewModel = viewModel
                )
            }
        }
    }
}