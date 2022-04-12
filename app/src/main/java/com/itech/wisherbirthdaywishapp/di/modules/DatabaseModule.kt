package com.itech.wisherbirthdaywishapp.di.modules

import android.app.Application
import androidx.room.Room
import com.itech.wisherbirthdaywishapp.database.db.FriendListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Volatile
    private  var INSTANCE: FriendListDatabase? = null

    @Singleton
    @Provides
    fun getDataBase(app: Application): FriendListDatabase {
        val tempInstance = INSTANCE
        if(tempInstance!=null){
            return tempInstance
        }
        synchronized(this){
            val instance = Room.databaseBuilder(app.applicationContext,
                FriendListDatabase::class.java,
                "user_database").build()
            INSTANCE = instance
            return instance
        }
    }
}