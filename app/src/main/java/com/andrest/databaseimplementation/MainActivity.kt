package com.andrest.databaseimplementation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrest.databaseimplementation.adapters.UserListAdapter
import com.andrest.databaseimplementation.databinding.ActivityMainBinding
import com.andrest.databaseimplementation.interfaces.OnClickListener
import com.andrest.databaseimplementation.models.User
import com.andrest.databaseimplementation.viewModel.UserViewModel
import com.andrest.databaseimplementation.views.PostActivity

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val adapter = UserListAdapter(this)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)

        binding.progressBar.visibility = View.VISIBLE
        userViewModel.userData.observe(this) {
            adapter.setData(it)
        }
        binding.progressBar.visibility = View.GONE

    }

    private fun launchPostActivity(user: User) {
        val intent = Intent(this, PostActivity::class.java)
        intent.putExtra(USER_KEY, user)
        startActivity(intent)
    }

    override fun onClick(user: User) {
        launchPostActivity(user)
    }

    companion object {
        const val USER_KEY = "user"
    }
}