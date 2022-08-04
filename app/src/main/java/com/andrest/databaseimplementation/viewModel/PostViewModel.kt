package com.andrest.databaseimplementation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.andrest.databaseimplementation.UserApplication
import com.andrest.databaseimplementation.db.UserDB
import com.andrest.databaseimplementation.models.Post
import com.andrest.databaseimplementation.repository.UserRepository
import kotlinx.coroutines.launch

class PostViewModel(application: Application) : AndroidViewModel(application) {


    var dataByUser: MutableLiveData<List<Post>> = MutableLiveData<List<Post>>()
    private var userRepo: UserRepository
    var userID = 0

    init {
        val userDao = UserDB.getDatabase(application).userDao()
        userRepo = UserRepository(userDao, (application as UserApplication).room)
        viewModelScope.launch {
            dataByUser.value = userRepo.getDataByUser(userID)
        }
    }

    fun setId(userid: Int) {
        userID = userid
    }

}