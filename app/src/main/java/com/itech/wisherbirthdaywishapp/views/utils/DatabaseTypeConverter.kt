package com.itech.wisherbirthdaywishapp.views.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class DatabaseTypeConverter {

    @TypeConverter
    fun fromString(value: String): Bitmap {
        val imageBytes = Base64.decode(value, 0)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }

    @TypeConverter
    fun fromBitmap(bitmap: Bitmap) :String{
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)

    }

}