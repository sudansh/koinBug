package app.sudansh.domain

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import org.koin.core.annotation.Single

@Single
class PreferencesHelper(context: Context) {
    val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val editor = preferences.edit()

    fun refresh() {
        preferences.getFloat("float", 0f)
    }
}