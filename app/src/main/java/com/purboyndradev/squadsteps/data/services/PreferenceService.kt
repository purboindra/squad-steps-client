package com.purboyndradev.squadsteps.data.services

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.purboyndradev.squadsteps.helper.AppKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferenceService(private val context: Context) {
    companion object {
        private val REFRESH_TOKEN_KEY = stringPreferencesKey(AppKey.REFRESH_TOKEN)
        private val ACCESS_TOKEN_KEY = stringPreferencesKey(AppKey.ACCESS_TOKEN)
    }

    val accessToken: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[ACCESS_TOKEN_KEY]
        }

    val refreshToken: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[REFRESH_TOKEN_KEY]
        }

    suspend fun saveAccessToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN_KEY] = token
        }
    }

    suspend fun saveRefreshToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[REFRESH_TOKEN_KEY] = token
        }
    }

    suspend fun clearAll() {
        context.dataStore.edit { it.clear() }
    }
}