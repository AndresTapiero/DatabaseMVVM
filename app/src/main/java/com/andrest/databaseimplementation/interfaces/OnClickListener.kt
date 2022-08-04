package com.andrest.databaseimplementation.interfaces

import com.andrest.databaseimplementation.models.User

interface OnClickListener {
    fun onClick(user: User)
}