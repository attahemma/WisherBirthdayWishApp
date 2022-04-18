package com.itech.wisherbirthdaywishapp.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Wish(
    @PrimaryKey(autoGenerate = false)
    val wish: String
)