package ru.ifedorov.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.ifedorov.vknewsclient.ui.LoginScreen
import ru.ifedorov.vknewsclient.ui.theme.VKNewsClientTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKNewsClientTheme {
                LoginScreen()
            }
        }
    }
}