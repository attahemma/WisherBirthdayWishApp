package com.itech.wisherbirthdaywishapp.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.itech.wisherbirthdaywishapp.R
import java.io.Serializable

@Entity
data class Gift(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val imageResource: Int,
    val wish: String
) : Serializable

