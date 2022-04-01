package com.itech.wisherbirthdaywishapp.repositories

import android.content.Context
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.itech.wisherbirthdaywishapp.database.GiftDatabase
import com.itech.wisherbirthdaywishapp.model.dao.GiftDao
import com.itech.wisherbirthdaywishapp.model.entities.Gift
import com.itech.wisherbirthdaywishapp.model.entities.Wish
import com.itech.wisherbirthdaywishapp.model.entities.relations.GiftAndWish

class GiftRepository( val context: Context) {
    private val giftDao: GiftDao = GiftDatabase.getInstance(context).giftDao

    suspend fun insertWish(wish: Wish) {
        giftDao.insertWish(wish)
    }

    suspend fun insertGift(gift: Gift) {
        giftDao.insertGift(gift)
    }

    suspend fun getGiftsWithoutWishes(): List<Gift> {
        return giftDao.getGiftsWithoutWishes()
    }

    suspend fun getGiftsWithWishes(): List<GiftAndWish> {
        return giftDao.getGiftsWithWishes()
    }

    suspend fun getGiftWithWishById(id: String): GiftAndWish {
        return giftDao.getGiftWithWishById(id)
    }

}