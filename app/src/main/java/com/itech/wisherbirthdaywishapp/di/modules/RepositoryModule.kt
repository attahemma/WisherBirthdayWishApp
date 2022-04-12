package com.itech.wisherbirthdaywishapp.di.modules

import com.itech.wisherbirthdaywishapp.database.db.FriendListDatabase
import com.itech.wisherbirthdaywishapp.database.repository.FriendRepositoryImpl
import com.itech.wisherbirthdaywishapp.database.repository.IFriendRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideFriendRepository(db: FriendListDatabase): IFriendRepository {
        return FriendRepositoryImpl(db)
    }
}