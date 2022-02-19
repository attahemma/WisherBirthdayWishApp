package com.itech.wisherbirthdaywishapp.views

import android.graphics.Typeface
import android.graphics.fonts.FontFamily
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.TextView
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.util.TextFormatter

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var tvIntroText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        tvIntroText = findViewById(R.id.intro_text)

        tvIntroText.text = TextFormatter.applyExclusiveStyle(
            "Let's Start",
            0,
            5,
            Typeface.BOLD
        )

    }
}