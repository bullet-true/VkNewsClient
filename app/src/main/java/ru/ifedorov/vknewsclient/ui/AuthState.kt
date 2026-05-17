package ru.ifedorov.vknewsclient.ui

sealed interface AuthState {

    data object Initial : AuthState
    data object Authorized : AuthState
    data object NotAuthorized : AuthState
}