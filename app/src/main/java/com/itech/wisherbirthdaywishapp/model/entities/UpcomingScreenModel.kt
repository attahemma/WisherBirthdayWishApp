package com.itech.wisherbirthdaywishapp.model.entities

import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Friend_Table")
data class UpcomingScreenModel(
    @PrimaryKey(autoGenerate = true) val id:Int,
    var contactImage:Bitmap? = null,
    val fullName: String? = null,
    val date: String? = null
)
