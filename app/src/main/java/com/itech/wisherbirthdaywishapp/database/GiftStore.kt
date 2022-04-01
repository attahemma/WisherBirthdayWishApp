package com.itech.wisherbirthdaywishapp.database

import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.model.entities.Gift
import java.util.*

object GiftStore {
    val availableGifts = arrayListOf<Gift>(
       Gift(
           UUID.randomUUID().toString(),
           R.drawable.one,
           "dummy"
       ),

        Gift(
            UUID.randomUUID().toString(),
            R.drawable.two,
            "dummy"
        ),

        Gift(
            UUID.randomUUID().toString(),
            R.drawable.three,
            "dummy"
        ),

        Gift(
            UUID.randomUUID().toString(),
            R.drawable.four,
            "dummy"
        ),

        Gift(
            UUID.randomUUID().toString(),
            R.drawable.five,
            "dummy"
        ),

        Gift(
            UUID.randomUUID().toString(),
            R.drawable.six,
            "dummy"
        ),

        Gift(
            UUID.randomUUID().toString(),
            R.drawable.seven,
            "dummy"
        ),

        Gift(
            UUID.randomUUID().toString(),
            R.drawable.eight,
            "dummy"
        ),

        Gift(
            UUID.randomUUID().toString(),
            R.drawable.nine,
            "dummy"
        )
    )
}