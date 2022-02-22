package com.itech.wisherbirthdaywishapp.views.utils

import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan

object TextFormatter {
    fun convertToSpannableString(
        text: String, from: Int, to: Int,
        typeface: Int
    ): SpannableString {

        val spannableString = SpannableString(text)
            .apply {
                setSpan(StyleSpan(typeface), from, to, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
            }
        return spannableString
    }
}