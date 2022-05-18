package com.andrest.databaseimplementation

import android.app.Application
import android.util.Log
import com.andrest.databaseimplementation.db.UserDB

class UserApp : Application() {

    lateinit var room: UserDB
    override fun onCreate() {
        super.onCreate()
        room = UserDB.getDatabase(this)
    }
}

