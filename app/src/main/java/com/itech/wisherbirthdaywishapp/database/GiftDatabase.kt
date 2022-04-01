package com.itech.wisherbirthdaywishapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.itech.wisherbirthdaywishapp.model.dao.GiftDao
import com.itech.wisherbirthdaywishapp.model.entities.Gift
import com.itech.wisherbirthdaywishapp.model.entities.Wish

@Database(
    entities = [
        Gift::class,
        Wish::class
    ],
    version = 1, exportSchema = true
)
abstract class GiftDatabase : RoomDatabase() {
    abstract val giftDao: GiftDao

    companion object {
        @Volatile
        private var INSTANCE: GiftDatabase? = null

        fun getInstance(context: Context): GiftDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    GiftDatabase::class.java,
                    "gift_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}