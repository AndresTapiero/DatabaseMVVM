package com.andrest.databaseimplementation.api

import com.andrest.databaseimplementation.models.User
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("/users")
    fun getAllUsers(): Call<List<User>>
}