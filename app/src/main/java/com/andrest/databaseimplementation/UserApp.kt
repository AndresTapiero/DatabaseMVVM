package com.andrest.databaseimplementation

import android.app.Application
import android.util.Log
import com.andrest.databaseimplementation.db.UserDB

class UserApp : Application() {

    lateinit var room: UserDB
    override fun onCreate() {
        super.onCreate()
        Log.e("Andres", "appli $applicationContext")

        room = UserDB.getDatabase(this)
        /*     room = Room.databaseBuilder(applicationContext, UserDB::class.java, "user")
                .build()*/
    }
}

