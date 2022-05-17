package com.andrest.databaseimplementation.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.andrest.databaseimplementation.models.User
import com.andrest.databaseimplementation.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {

    var userData: LiveData<List<User>>
    private var userRepo: UserRepository = UserRepository()

    init {
        userData = userRepo.getUsers()
    }

    fun getPosts(): LiveData<List<User>> {
        if (userData == null) {
            Log.i("Andres", " Melosooo entre al log")
            userData = userRepo.getUsers()
        }
        return userData
    }

    fun onClick(user: User) {
        Toast.makeText(getApplication(), "user ${user.id} ${user.name}", Toast.LENGTH_LONG).show()
    }


/*    fun getUser(): LiveData<List<User?>?>? {
        if (mutableLiveData == null) {
            mutableLiveData = repository.service()
        }
        return mutableLiveData
    }*/
}