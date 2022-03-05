package com.itech.wisherbirthdaywishapp.database

import com.itech.wisherbirthdaywishapp.R
import java.io.Serializable

data class Gift(
    val id: Int,
    val name: String? = null,
    val resource: Int = R.drawable.ic_baseline_favorite_24,
    val price: Float? = 0f
) : Serializable

