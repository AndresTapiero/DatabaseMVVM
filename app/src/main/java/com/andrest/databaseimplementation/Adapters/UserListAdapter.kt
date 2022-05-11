package com.andrest.databaseimplementation.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andrest.databaseimplementation.R
import com.andrest.databaseimplementation.models.User


class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private var userList = emptyList<User>()
    //lateinit var userClick: UserClick

/*    fun setOnItemClickListener(listener: UserClick) {
        userClick = listener
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.bind(currentUser)

    }

    override fun getItemCount(): Int = userList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.name)
        private val phone = view.findViewById<TextView>(R.id.phone)
        private val email = view.findViewById<TextView>(R.id.email)
        private val btn = view.findViewById<Button>(R.id.btn_view_post)

        fun bind(currentUser: User) {
            name.text = currentUser.name
            phone.text = currentUser.phone
            email.text = currentUser.email
            btn.setOnClickListener {
            }
        }

    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}