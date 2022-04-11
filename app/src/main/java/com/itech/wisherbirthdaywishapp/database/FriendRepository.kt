package com.itech.wisherbirthdaywishapp.database

import androidx.lifecycle.LiveData
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel

class FriendRepository (private val friendDao: FriendListDao) {
        val readAllData: LiveData<List<UpcomingScreenModel>> = friendDao.readAllData()

        suspend fun addUser(friend: UpcomingScreenModel) {
            friendDao.addUser(friend)
        }

    }
