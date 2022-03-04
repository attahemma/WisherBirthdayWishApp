package com.itech.wisherbirthdaywishapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.itech.wisherbirthdaywishapp.model.UpcomingScreenModel
import com.itech.wisherbirthdaywishapp.views.utils.DatabaseTypeConverter


@Database(entities = [
    UpcomingScreenModel::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseTypeConverter::class)
abstract class FriendListDatabase : RoomDatabase() {
    abstract fun friendList():FriendListDao
    companion object{
        @Volatile
        private var InstanceOfDatabase:FriendListDatabase? = null

        fun getDatabase(context: Context):FriendListDatabase{
            val tempIntance = InstanceOfDatabase
            if (tempIntance != null){
                return tempIntance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FriendListDatabase::class.java,
                    "user_database"
                ).build()
                InstanceOfDatabase = instance
                return instance
            }
        }
    }
}