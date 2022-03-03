package com.itech.wisherbirthdaywishapp.database

import androidx.lifecycle.LiveData

import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel

@Dao
interface FriendListDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(friend: UpcomingScreenModel)

    @Query("SELECT * FROM Friend_Table ORDER BY fullName ASC")
    fun readAllData(): LiveData<List<UpcomingScreenModel>>
}