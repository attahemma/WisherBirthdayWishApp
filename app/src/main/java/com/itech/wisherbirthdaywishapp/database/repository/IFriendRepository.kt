package com.itech.wisherbirthdaywishapp.database.repository

import androidx.lifecycle.LiveData
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel

interface IFriendRepository {
    fun readAllData(): LiveData<List<UpcomingScreenModel>>
    suspend fun addUser(friend: UpcomingScreenModel)
}