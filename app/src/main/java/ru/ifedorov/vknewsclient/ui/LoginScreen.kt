package ru.ifedorov.vknewsclient.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vk.id.onetap.compose.onetap.OneTap

@Composable
fun LoginScreen(
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OneTap(
            onAuth = { oAuth, token ->
                // Использование токена.
            },
            onFail = { oAuth, fail ->

            }
        )
    }
}