package com.andrest.databaseimplementation.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrest.databaseimplementation.R
import com.andrest.databaseimplementation.adapters.PostAdapter
import com.andrest.databaseimplementation.databinding.ActivityPostBinding
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
        val userName = intent.getStringExtra("name")
        val userPhone = intent.getStringExtra("phone")
        val userEmail = intent.getStringExtra("email")

        binding.name.text = userName
        binding.phone.text = userPhone
        binding.email.text = userEmail

        postViewModel.setId(2)

        postViewModel.dataByUser.observe(this) {
            postViewModel.setId(2)
            adapter.setData(it)
        }


/*        userViewModel.dataByUser.observe(this) {
            adapter.setData(it)
        }*/
    }


}