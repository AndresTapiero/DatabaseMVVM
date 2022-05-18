package com.andrest.databaseimplementation.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.andrest.databaseimplementation.models.User

@Dao
interface UserDao {

/*    @Insert
    suspend fun insertUsers(users: List<User>)*/

    @Query("SELECT * from User")
    fun getAll(): LiveData<List<User>>


}