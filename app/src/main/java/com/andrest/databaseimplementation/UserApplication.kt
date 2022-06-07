package com.andrest.databaseimplementation

import android.app.Application
import com.andrest.databaseimplementation.db.UserDB
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UserApplication : Application() {

    lateinit var room: UserDB
    override fun onCreate() {
        super.onCreate()
        room = UserDB.getDatabase(this)
    }
}

