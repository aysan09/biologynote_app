package com.example.biologyapp;

import android.content.Context;
import android.content.SharedPreferences;


public class ThemeManager {

    private static final String PREF_NAME = "theme_pref";
    private static final String KEY_IS_DARK = "is_dark";

    public static void setDarkMode(Context context, boolean isDark) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_IS_DARK, isDark);
        editor.apply();
    }

    public static boolean isDarkMode(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_IS_DARK, false); // default: light theme
    }

    public static int getTheme(Context context) {
        return isDarkMode(context) ? R.style.AppTheme_Dark : R.style.AppTheme_Light;
    }
}
