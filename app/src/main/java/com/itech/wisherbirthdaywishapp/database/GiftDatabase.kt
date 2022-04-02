package com.itech.wisherbirthdaywishapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.itech.wisherbirthdaywishapp.R
import com.itech.wisherbirthdaywishapp.model.dao.GiftDao
import com.itech.wisherbirthdaywishapp.model.entities.Gift
import com.itech.wisherbirthdaywishapp.model.entities.Wish
import java.util.*
import java.util.concurrent.Executors

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
        private val NUMBER_OF_THREADS = 4
        public val executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        fun getInstance(context: Context): GiftDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    GiftDatabase::class.java,
                    "gift_db"
                )
                    .addCallback(callback)
                    .build().also {
                        INSTANCE = it
                    }
            }
        }

        private val callback: RoomDatabase.Callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                executor.execute(Runnable {
                    val dao = INSTANCE?.giftDao
                    dao?.deleteAllGifts()
                    GiftStore.availableGifts.forEach {
                        dao?.insertGift(it)
                    }
                })
            }
        }
    }
}
