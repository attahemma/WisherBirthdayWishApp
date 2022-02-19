package com.itech.wisherbirthdaywishapp.util

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan

object TextFormatter {

    fun applyExclusiveStyle(text: String, from: Int, to: Int, typeface: Int): SpannableString {
        val spannableString = SpannableString(text).apply {
            setSpan(StyleSpan(typeface), from, to, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        }
        return spannableString
    }
}