package com.example.basics.model

import com.example.basics.R

data class UserProfile(val name: String, val status: Boolean, val drawableId: Int)

val userProfileList = arrayListOf<UserProfile>(
    UserProfile(name = "John Doe", status = true, R.drawable.user1),
    UserProfile(name = "Amanda Smith", status = false, R.drawable.amanada),
)
