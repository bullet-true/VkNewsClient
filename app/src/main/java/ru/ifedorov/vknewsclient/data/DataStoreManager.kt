package ru.ifedorov.vknewsclient.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.ifedorov.vknewsclient.data.DataStoreManager.Companion.PREFERENCES_DATASTORE_NAME

private val Context.dataStore by preferencesDataStore(name = PREFERENCES_DATASTORE_NAME)

class DataStoreManager(
    private val context: Context
) {

    suspend fun saveAccessToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN_KEY] = token
        }
    }

    val accessTokenFlow: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[ACCESS_TOKEN_KEY]
    }

    suspend fun clearAccessToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(ACCESS_TOKEN_KEY)
        }
    }

    companion object {
        const val PREFERENCES_DATASTORE_NAME = "vk_news_client_auth_preferences"
        const val ACCESS_TOKEN = "access_token"
        private val ACCESS_TOKEN_KEY = stringPreferencesKey(ACCESS_TOKEN)
    }
}