package com.andrest.databaseimplementation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrest.databaseimplementation.Adapters.UserListAdapter
import com.andrest.databaseimplementation.databinding.ActivityMainBinding
import com.andrest.databaseimplementation.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

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