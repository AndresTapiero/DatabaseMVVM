package com.andrest.databaseimplementation.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andrest.databaseimplementation.models.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    //@Transaction
    //suspend fun insertAll(users: List<User>) = users.forEach { insertUser(it) }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)

    @Query("SELECT * from User")
    fun getAll(): LiveData<List<User>>
}