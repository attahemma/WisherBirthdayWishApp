package com.itech.wisherbirthdaywishapp.di.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WisherApp:Application() {

    companion object{
        @get:Synchronized lateinit var application:WisherApp
        private set
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}