package ru.ifedorov.vknewsclient.presentation.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vk.id.onetap.compose.onetap.OneTap

@Composable
fun LoginScreen(
    onLoginSuccess: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OneTap(
            onAuth = { oAuth, token ->
                Log.d("VK_AUTH", token.token)
                onLoginSuccess(token.token)
            },
            onFail = { oAuth, fail ->
                Log.d("VK_AUTH", fail.description)
            }
        )
    }
}