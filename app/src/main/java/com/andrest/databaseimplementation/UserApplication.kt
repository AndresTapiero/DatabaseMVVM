package com.andrest.databaseimplementation

import android.app.Application
import com.andrest.databaseimplementation.db.UserDB

class UserApplication : Application() {

    lateinit var room: UserDB
    override fun onCreate() {
        super.onCreate()
        room = UserDB.getDatabase(this)
    }
}

