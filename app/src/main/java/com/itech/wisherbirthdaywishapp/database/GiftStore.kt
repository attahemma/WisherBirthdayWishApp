package com.itech.wisherbirthdaywishapp.database

import com.itech.wisherbirthdaywishapp.R

object GiftStore {
    val availableGifts = arrayListOf<Gift>(
        Gift(
            1, "ballon",
            R.drawable.ballon, 2.3f
        ),

        Gift(
            2, "cake",
            R.drawable.cake, 18.0f
        ),

        Gift(
            3, "flower",
            R.drawable.flower, 7.5f
        )
    )
}