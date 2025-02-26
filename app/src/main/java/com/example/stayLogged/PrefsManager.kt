package com.example.stayLogged

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUser(username: String) {
        prefs.edit().putString("username", username).apply()
    }

    fun getUser(): String? {
        return prefs.getString("username", null)
    }

    fun clearUser() {
        prefs.edit().clear().apply()
    }
}