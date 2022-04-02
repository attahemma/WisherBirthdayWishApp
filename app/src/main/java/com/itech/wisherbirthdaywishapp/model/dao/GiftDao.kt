package com.itech.wisherbirthdaywishapp.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itech.wisherbirthdaywishapp.model.entities.Gift
import com.itech.wisherbirthdaywishapp.model.entities.Wish
import com.itech.wisherbirthdaywishapp.model.entities.relations.GiftAndWish

@Dao
interface GiftDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWish(wish: Wish)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGift(gift: Gift)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGifts(gifts: List<Gift>)

    @Query("SELECT * FROM gift")
    fun getGifts(): LiveData<List<Gift>>

    @Transaction
    @Query("SELECT * FROM gift")
    fun getGiftsWithWishes(): LiveData<List<GiftAndWish>>

    @Transaction
    @Query("SELECT * FROM gift WHERE id = :id")
    fun getGiftWithWishById(id: String): LiveData<GiftAndWish>

    @Delete
    fun deleteGift(gift: Gift)

    @Query("DELETE FROM gift")
    fun deleteAllGifts()

    @Transaction
    @Query("DELETE FROM gift")
    fun deleteAllGiftsWithWishes()
}