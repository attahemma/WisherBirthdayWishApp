package com.itech.wisherbirthdaywishapp.model

import android.graphics.Bitmap
import androidx.annotation.DrawableRes

data class UpcomingScreenModel(
    var contactImage:Bitmap? = null,
    val fullName: String? = null,
    val date: String? = null
)
