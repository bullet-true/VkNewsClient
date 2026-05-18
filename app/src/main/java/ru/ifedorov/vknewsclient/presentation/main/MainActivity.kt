package ru.ifedorov.vknewsclient.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.CircularProgressIndicator
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.ifedorov.vknewsclient.ui.theme.VKNewsClientTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKNewsClientTheme {
                val viewModel: AuthViewModel = viewModel(
                    factory = AuthViewModelFactory(applicationContext)
                )
                val authState = viewModel.authState.collectAsStateWithLifecycle()

                when (authState.value) {
                    AuthState.Authorized -> {
                        MainScreen()
                    }

                    AuthState.NotAuthorized -> {
                        LoginScreen(
                            onLoginSuccess = { token ->
                                viewModel.performAuthResult(token)
                            }
                        )
                    }

                    AuthState.Initial -> {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}