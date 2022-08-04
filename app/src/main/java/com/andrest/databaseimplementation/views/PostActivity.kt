package com.andrest.databaseimplementation.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrest.databaseimplementation.MainActivity
import com.andrest.databaseimplementation.R
import com.andrest.databaseimplementation.adapters.PostAdapter
import com.andrest.databaseimplementation.databinding.ActivityPostBinding
import com.andrest.databaseimplementation.models.User
import com.andrest.databaseimplementation.viewModel.PostViewModel

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private lateinit var postViewModel: PostViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]

        val adapter = PostAdapter()
        binding.rvPostsResults.adapter = adapter
        binding.rvPostsResults.layoutManager = LinearLayoutManager(this)
        val user = intent.extras?.get(MainActivity.USER_KEY) as User

        binding.name.text = user.name
        binding.phone.text = user.phone
        binding.email.text = user.email


        postViewModel.dataByUser.observe(this) {
            adapter.setData(it)
        }
        postViewModel.getDataById(user.id)

    }


}