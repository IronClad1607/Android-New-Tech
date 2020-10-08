package com.ironclad.viewmodelscopedemo.repo

import com.ironclad.viewmodelscopedemo.model.User
import kotlinx.coroutines.delay

class UserRepo {

    suspend fun getUsers(): ArrayList<User> {
        delay(8000)

        return arrayListOf(
            User(1, "Ishaan"),
            User(2, "Sidhi"),
            User(3, "Nupur"),
            User(4, "Ashish")
        )
    }
}