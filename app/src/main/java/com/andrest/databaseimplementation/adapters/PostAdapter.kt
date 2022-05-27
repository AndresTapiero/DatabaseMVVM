package com.andrest.databaseimplementation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andrest.databaseimplementation.R
import com.andrest.databaseimplementation.models.Post

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var postList = emptyList<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater
           .from(parent.context)
           .inflate(R.layout.post_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPost = postList[position]
        holder.bind(currentPost)
    }

    override fun getItemCount(): Int = postList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.title)
        private val body = view.findViewById<TextView>(R.id.body)

        fun bind(currentPost: Post) {
            title.text = currentPost.title
            body.text = currentPost.body
        }

    }

}