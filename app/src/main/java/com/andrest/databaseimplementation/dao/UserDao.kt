package com.andrest.databaseimplementation.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.andrest.databaseimplementation.models.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Transaction
    suspend fun insertAll(users: List<User>) = users.forEach { insertUser(it) }

    @Query("SELECT * from User")
    suspend fun getAll(): List<User>
}