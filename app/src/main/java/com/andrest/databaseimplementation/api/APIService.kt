package com.andrest.databaseimplementation.api

import com.andrest.databaseimplementation.models.Post
import com.andrest.databaseimplementation.models.User
import com.andrest.databaseimplementation.rest.EndPoints
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET(EndPoints.GET_USERS)
    fun getAllUsers(): Call<List<User>>

    @GET(EndPoints.GET_POST_USER)
    fun getUserPosts(@Query("userId") id: Int): Call<List<Post>>
}