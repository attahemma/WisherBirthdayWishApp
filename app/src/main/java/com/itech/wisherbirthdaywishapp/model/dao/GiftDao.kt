package com.itech.wisherbirthdaywishapp.model.dao

import androidx.room.*
import com.itech.wisherbirthdaywishapp.model.entities.Gift
import com.itech.wisherbirthdaywishapp.model.entities.Wish
import com.itech.wisherbirthdaywishapp.model.entities.relations.GiftAndWish

@Dao
interface GiftDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWish(wish: Wish)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGift(gift: Gift)

    @Query("SELECT * FROM gift")
    suspend fun getGiftsWithoutWishes(): List<Gift>

    @Transaction
    @Query("SELECT * FROM gift")
    suspend fun getGiftsWithWishes(): List<GiftAndWish>

    @Transaction
    @Query("SELECT * FROM gift WHERE id = :id")
    suspend fun getGiftWithWishById(id: String): GiftAndWish
}