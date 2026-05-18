package ru.ifedorov.vknewsclient.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.ifedorov.vknewsclient.data.DataStoreManager

class AuthViewModel(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    init {
        checkAuthState()
    }

    private fun checkAuthState() {
        viewModelScope.launch {
            dataStoreManager.accessTokenFlow.collect { token ->

                _authState.value =
                    if (token.isNullOrEmpty()) {
                        AuthState.NotAuthorized
                    } else {
                        AuthState.Authorized
                    }
            }
        }
    }

    fun performAuthResult(token: String) {
        viewModelScope.launch {
            dataStoreManager.saveAccessToken(token)
        }
    }

    fun logout() {
        viewModelScope.launch {
            dataStoreManager.clearAccessToken()
        }
    }
}