package com.example.mvvmsample.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.mvvmsample.BuildConfig
import com.example.mvvmsample.R

@SuppressLint("CommitPrefEdits")
class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    private val sharedPrefsEditor: SharedPreferences.Editor
    private val PREF_NAME: String = BuildConfig.APPLICATION_ID + "PreferenceStorage"

    private val masterKeyAlias by lazy {  MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)}

    companion object {
        const val USER_TOKEN = "user_token"
    }

    init {
        prefs = EncryptedSharedPreferences.create(
            PREF_NAME,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        sharedPrefsEditor = prefs.edit()

        //sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        //sharedPrefsEditor = sharedPreferences.edit()
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        // val editor = prefs.edit()
        val editor = sharedPrefsEditor
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun logoutUser() {
        // Clearing all data from Shared Preferences
        sharedPrefsEditor.clear()
        sharedPrefsEditor.commit()
        /*// After logout redirect user to Login Activity
        val intent = Intent(MyApplication.instance.applicationContext, LoginActivity::class.java)
        // Closing all the Activities
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        MyApplication.instance.applicationContext.startActivity(intent)*/
    }
}