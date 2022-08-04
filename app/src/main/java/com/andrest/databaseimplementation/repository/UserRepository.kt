package com.andrest.databaseimplementation.repository

import androidx.lifecycle.MutableLiveData
import com.andrest.databaseimplementation.api.APIService
import com.andrest.databaseimplementation.dao.UserDao
import com.andrest.databaseimplementation.db.UserDB
import com.andrest.databaseimplementation.models.Post
import com.andrest.databaseimplementation.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UserRepository(private val userDao: UserDao, private val userDB: UserDB) {
    private val mutableLiveData: MutableLiveData<List<User>> = MutableLiveData()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(APIService::class.java)

    suspend fun getUsers(): List<User> {
        val users = getDBUser()

        if (users.isEmpty()) {
            withContext(Dispatchers.IO) {
                users.let { userDB.userDao().insertAll(it) }
            }
        }
        return users
    }

    suspend fun getDataByUser(userid: Int): List<Post> {
        return getPosts(userid)
    }

    private suspend fun getPosts(userid: Int) = suspendCoroutine<List<Post>> { continuation ->
        service.getUserPosts(userid).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null) {
                    continuation.resume(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                continuation.resume(arrayListOf())
            }
        })
    }

    private suspend fun getDBUser() = suspendCoroutine<List<User>> { continuation ->
        service.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful && response.body() != null) {
                    continuation.resume(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                continuation.resume(arrayListOf())
            }
        })
    }

}