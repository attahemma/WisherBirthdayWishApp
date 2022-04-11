package com.itech.wisherbirthdaywishapp.di.modules

import android.content.Context
import com.itech.wisherbirthdaywishapp.di.app.WisherApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    internal fun provideApplication(@ApplicationContext app: Context): WisherApp {
        return app as WisherApp
    }
}