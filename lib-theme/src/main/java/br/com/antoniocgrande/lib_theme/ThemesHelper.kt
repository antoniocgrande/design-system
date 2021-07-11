package br.com.antoniocgrande.lib_theme

import android.content.Context

class ThemesHelper(context: Context, theme: Int) {

    init {
        context.setTheme(theme)
    }

    companion object {
        val APPTHEME = R.style.AppTheme
        val APPTHEME_NOACTIONBAR = R.style.AppTheme_NoActionBar
        val APPTHEME_PINK = R.style.AppTheme_PINK
        val APPTHEME_BLUE = R.style.AppTheme_BLUE
        val APPTHEME_RED = R.style.AppTheme_RED
    }

}