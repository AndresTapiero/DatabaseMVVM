package com.andrest.databaseimplementation.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrest.databaseimplementation.R
import com.andrest.databaseimplementation.adapters.PostAdapter
import com.andrest.databaseimplementation.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        val adapter = PostAdapter()
        binding.rvPostsResults.adapter = adapter
        binding.rvPostsResults.layoutManager = LinearLayoutManager(this)

    }
}