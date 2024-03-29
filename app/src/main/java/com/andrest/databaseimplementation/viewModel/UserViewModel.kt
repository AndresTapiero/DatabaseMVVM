package com.andrest.databaseimplementation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.andrest.databaseimplementation.UserApplication
import com.andrest.databaseimplementation.db.UserDB
import com.andrest.databaseimplementation.models.User
import com.andrest.databaseimplementation.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    var userData: MutableLiveData<List<User>> = MutableLiveData<List<User>>()

    private var userRepo: UserRepository

    init {
        val userDao = UserDB.getDatabase(application).userDao()
        userRepo = UserRepository(userDao, (application as UserApplication).room)
        viewModelScope.launch {
            userData.value = userRepo.getUsers()
        }
    }

}