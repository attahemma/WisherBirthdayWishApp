package com.itech.wisherbirthdaywishapp.views

import android.graphics.Typeface.BOLD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.views.utils.TextFormatter

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var tvIntroText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        tvIntroText = findViewById(R.id.intro_text)
        tvIntroText.text = TextFormatter.convertToSpannableString(
            "Let's Start",
            0, 5, BOLD
        )
    }
}