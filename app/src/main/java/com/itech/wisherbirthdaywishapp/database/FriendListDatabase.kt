package com.itech.wisherbirthdaywishapp.database

import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel


@Database(entities = [
    UpcomingScreenModel::class], version = 1, exportSchema = false)

abstract class FriendListDatabase : RoomDatabase() {

    abstract fun friendList():FriendListDao
//    abstract fun insertTopHotelDao(): TopHotelDao



}