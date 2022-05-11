package com.andrest.databaseimplementation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.andrest.databaseimplementation.models.User
import com.andrest.databaseimplementation.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    var userData: LiveData<List<User>>
    private var userRepo: UserRepository = UserRepository()

    init {
        Log.i("Andres", " Melosooo entre al log 2")
        userData = userRepo.getUsers()
    }

    fun getPosts(): LiveData<List<User>> {
        if (userData == null) {
            Log.i("Andres", " Melosooo entre al log")
            userData = userRepo.getUsers()
        }
        return userData
    }


/*    fun getUser(): LiveData<List<User?>?>? {
        if (mutableLiveData == null) {
            mutableLiveData = repository.service()
        }
        return mutableLiveData
    }*/
}