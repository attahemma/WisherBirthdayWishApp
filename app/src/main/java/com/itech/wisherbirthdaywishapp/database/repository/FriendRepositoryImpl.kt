package com.itech.wisherbirthdaywishapp.database.repository

import androidx.lifecycle.LiveData
import com.itech.wisherbirthdaywishapp.database.FriendListDao
import com.itech.wisherbirthdaywishapp.database.db.FriendListDatabase
import com.itech.wisherbirthdaywishapp.di.app.WisherApp
import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel
import javax.inject.Inject

class FriendRepositoryImpl @Inject constructor (
    private val db : FriendListDatabase
) :  IFriendRepository {

    override fun readAllData(): LiveData<List<UpcomingScreenModel>> {
        return db.friendList().readAllData()
    }

    override suspend fun addUser(friend: UpcomingScreenModel) {
        db.friendList().addUser(friend)
    }

}
