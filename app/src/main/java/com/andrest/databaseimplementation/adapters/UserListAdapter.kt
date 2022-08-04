package com.andrest.databaseimplementation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrest.databaseimplementation.R
import com.andrest.databaseimplementation.databinding.UserListItemBinding
import com.andrest.databaseimplementation.interfaces.OnClickListener
import com.andrest.databaseimplementation.models.User


class UserListAdapter(private var listener: OnClickListener) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private var userList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser = userList[position]

        with(holder) {
            bind(currentUser)
            setListener(currentUser)
        }
    }

    override fun getItemCount(): Int = userList.size

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        private val binding = UserListItemBinding.bind(view)

        fun bind(currentUser: User) {
            with(binding) {
                name.text = currentUser.name
                phone.text = currentUser.phone
                email.text = currentUser.email
            }
        }

        fun setListener(user: User) {
            binding.btnViewPost.setOnClickListener {
                listener.onClick(user)
            }
        }
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}