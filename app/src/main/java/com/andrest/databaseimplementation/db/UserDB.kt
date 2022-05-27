package com.andrest.databaseimplementation.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andrest.databaseimplementation.dao.UserDao
import com.andrest.databaseimplementation.models.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)

abstract class UserDB : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserDB? = null

        fun getDatabase(context: Context): UserDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDB::class.java,
                    "user"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}