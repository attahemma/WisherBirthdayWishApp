package com.itech.wisherbirthdaywishapp.views.utils

import com.itech.wisherbirthdaywishapp.database.Gift

interface GiftingInterface {
    fun openGiftBottomSheet(gift: Gift?)
}