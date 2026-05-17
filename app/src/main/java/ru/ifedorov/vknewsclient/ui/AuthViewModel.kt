package ru.ifedorov.vknewsclient.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    private var accessToken: String? = null

    fun performAuthResult(token: String) {
        accessToken = token
        _authState.value = AuthState.Authorized
    }

    fun logout() {
        accessToken = null
        _authState.value = AuthState.NotAuthorized
    }
}