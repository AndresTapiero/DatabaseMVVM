package com.andrest.databaseimplementation

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrest.databaseimplementation.Adapters.UserListAdapter
import com.andrest.databaseimplementation.databinding.ActivityMainBinding
import com.andrest.databaseimplementation.models.User
import com.andrest.databaseimplementation.viewModel.UserViewModel
import com.andrest.databaseimplementation.views.PostActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        appViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val adapter = UserListAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)

        binding.progressBar.visibility = View.VISIBLE
        appViewModel.userData.observe(this) {
            adapter.setData(it)
        }
        binding.progressBar.visibility = View.GONE

        //onClickUser()
    }

    fun onClickUser(user: User) {

        var adapter = UserListAdapter()
        val intent = Intent(this@MainActivity, PostActivity::class.java)
        //intent.putExtra("user", user)
        Log.i("Andres", "user ${user.id}")
        startActivity(intent)
    }




}