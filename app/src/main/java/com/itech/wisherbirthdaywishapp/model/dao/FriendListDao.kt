package com.itech.wisherbirthdaywishapp.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.itech.wisherbirthdaywishapp.model.entities.UpcomingScreenModel

@Dao
interface FriendListDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(friend: UpcomingScreenModel)

    @Query("SELECT * FROM Friend_Table ORDER BY fullName ASC")
    fun readAllData(): LiveData<List<UpcomingScreenModel>>
}