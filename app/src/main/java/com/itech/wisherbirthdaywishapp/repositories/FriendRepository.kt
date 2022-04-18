package com.itech.wisherbirthdaywishapp.repositories

import androidx.lifecycle.LiveData
import com.itech.wisherbirthdaywishapp.model.entities.UpcomingScreenModel
import com.itech.wisherbirthdaywishapp.model.dao.FriendListDao

class FriendRepository (private val friendDao: FriendListDao) {
        val readAllData: LiveData<List<UpcomingScreenModel>> = friendDao.readAllData()

        suspend fun addUser(friend: UpcomingScreenModel) {
            friendDao.addUser(friend)
        }

    }
