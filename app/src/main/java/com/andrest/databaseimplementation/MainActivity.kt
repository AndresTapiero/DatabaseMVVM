package com.andrest.databaseimplementation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrest.databaseimplementation.adapters.UserListAdapter
import com.andrest.databaseimplementation.databinding.ActivityMainBinding
import com.andrest.databaseimplementation.viewModel.UserViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    private val app = applicationContext as UserApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]


        lifecycleScope.launch {
            val users = app.room.userDao().getAll()
            //Log.d("Andres", "onCreate: ${users.size}")
        }

        val adapter = UserListAdapter {
            userViewModel.onClick(it)
        }
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)

        binding.progressBar.visibility = View.VISIBLE
        userViewModel.userData.observe(this) {
            adapter.setData(it)
        }
        binding.progressBar.visibility = View.GONE

    }

}