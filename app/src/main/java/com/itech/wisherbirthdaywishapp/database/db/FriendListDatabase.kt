package com.itech.wisherbirthdaywishapp.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.itech.wisherbirthdaywishapp.database.AddFriendsInfo
import com.itech.wisherbirthdaywishapp.database.AddFriendsInfoDao
import com.itech.wisherbirthdaywishapp.database.FriendListDao

import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel
import com.itech.wisherbirthdaywishapp.views.utils.DatabaseTypeConverter


@Database(entities = [
    UpcomingScreenModel::class,
    AddFriendsInfo::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseTypeConverter::class)
abstract class FriendListDatabase : RoomDatabase() {
    abstract fun friendList(): FriendListDao
    abstract fun addFriendsInfoDao(): AddFriendsInfoDao?
}