package com.example.weaphones

import android.content.Context
import java.util.Locale

object LanguageManager {

    private const val PREFS = "app_settings"
    private const val KEY_LANG = "language"

    fun setLanguage(context: Context, lang: String) {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_LANG, lang).apply()
    }


    fun getLanguage(context: Context): String {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return prefs.getString(KEY_LANG, "hu") ?: "hu"
    }

    fun applyLanguage(context: Context) {
        val lang = getLanguage(context)

        val locale = Locale(lang)
        Locale.setDefault(locale)

        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}