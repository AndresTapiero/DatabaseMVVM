package com.andrest.databaseimplementation.repository

import androidx.lifecycle.MutableLiveData
import com.andrest.databaseimplementation.api.APIService
import com.andrest.databaseimplementation.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository() {
    //private val userDao: UserDao
    val mutableLiveData: MutableLiveData<List<User>> = MutableLiveData()
    val insertData: MutableLiveData<List<User>> = MutableLiveData()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(APIService::class.java)

    fun getUsers(): MutableLiveData<List<User>> {

        service.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful && response.body() != null) {
                    mutableLiveData.value = (response.body())
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return mutableLiveData
    }

    fun addUsers(user: User) {

    }

}