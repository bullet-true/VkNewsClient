package ru.ifedorov.vknewsclient.presentation.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ifedorov.vknewsclient.data.DataStoreManager

class AuthViewModelFactory(
    context: Context
) : ViewModelProvider.Factory {

    private val dataStoreManager = DataStoreManager(context)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(dataStoreManager) as T
    }
}