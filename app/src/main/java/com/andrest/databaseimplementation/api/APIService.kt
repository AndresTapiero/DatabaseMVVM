package com.andrest.databaseimplementation.api

import com.andrest.databaseimplementation.models.Post
import com.andrest.databaseimplementation.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("/users")
    fun getAllUsers(): Call<List<User>>

    @GET("/posts?")
    fun getUserPosts(@Query("userId") id: Int): Call<List<Post>>
}