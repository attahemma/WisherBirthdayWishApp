package com.itech.wisherbirthdaywishapp.model.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.itech.wisherbirthdaywishapp.model.entities.Gift
import com.itech.wisherbirthdaywishapp.model.entities.Wish

data class GiftAndWish(
    @Embedded val gift: Gift,
    @Relation(
        parentColumn = "wish",
        entityColumn = "wish"
    )
    val wish: Wish
)