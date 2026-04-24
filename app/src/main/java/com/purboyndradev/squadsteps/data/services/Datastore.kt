package com.purboyndradev.squadsteps.data.services

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

internal const val dataStoreFileName = "user.preferences_pb"

class Datastore {
    companion object {
        fun getPreferencesDataStore(path: String) = PreferenceDataStoreFactory.createWithPath {
            path.toPath()
        }
    }
}