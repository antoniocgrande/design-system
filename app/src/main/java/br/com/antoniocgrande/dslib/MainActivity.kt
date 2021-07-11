package br.com.antoniocgrande.dslib

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.antoniocgrande.lib_theme.ThemesHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREFS_THEMES = "PREFS_THEMES"
    val THEME_SELECTED = "THEME_SELECTED"
    val THEME_DEFAULT = "THEME_DEFAULT"
    val THEME_BLUE = "THEME_BLUE"
    val THEME_PINK = "THEME_PINK"
    val THEME_RED = "THEME_RED"

    override fun onCreate(savedInstanceState: Bundle?) {
        val prefs = getSharedPreferences(PREFS_THEMES, MODE_PRIVATE)

        when (prefs.getString(THEME_SELECTED, THEME_DEFAULT)) {
            THEME_DEFAULT -> ThemesHelper(this, ThemesHelper.APPTHEME)
            THEME_BLUE -> ThemesHelper(this, ThemesHelper.APPTHEME_BLUE)
            THEME_PINK -> ThemesHelper(this, ThemesHelper.APPTHEME_PINK)
            THEME_RED -> ThemesHelper(this, ThemesHelper.APPTHEME_RED)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        viewDefault.setOnClickListener { saveTheme(THEME_DEFAULT) }
        viewBlue.setOnClickListener { saveTheme(THEME_BLUE) }
        viewPink.setOnClickListener { saveTheme(THEME_PINK) }
        viewRed.setOnClickListener { saveTheme(THEME_RED) }
    }

    private fun saveTheme(theme: String) {
        val editor = getSharedPreferences(PREFS_THEMES, MODE_PRIVATE).edit()
        editor.putString(THEME_SELECTED, theme)
        editor.apply()
        startActivity(Intent.makeRestartActivityTask(this.intent?.component))
    }

}