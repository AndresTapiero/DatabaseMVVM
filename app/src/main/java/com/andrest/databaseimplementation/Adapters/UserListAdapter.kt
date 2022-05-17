package com.andrest.databaseimplementation.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrest.databaseimplementation.R
import com.andrest.databaseimplementation.databinding.UserListItemBinding
import com.andrest.databaseimplementation.models.User


class UserListAdapter(private val onClick: (User) -> Unit) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private var userList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.bind(currentUser)
    }

    override fun getItemCount(): Int = userList.size

    class ViewHolder(view: View, private val listener: (User) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private val binding = UserListItemBinding.bind(view)

        fun bind(currentUser: User) {
            binding.name.text = currentUser.name
            binding.phone.text = currentUser.phone
            binding.email.text = currentUser.email
            binding.btnViewPost.setOnClickListener { listener(currentUser) }
        }
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}