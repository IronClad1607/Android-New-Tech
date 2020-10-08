package com.ironclad.viewmodelscopedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironclad.viewmodelscopedemo.model.User
import com.ironclad.viewmodelscopedemo.repo.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private var userRepo = UserRepo()
    var users = MutableLiveData<ArrayList<User>>()
    fun getUserData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                users.postValue(userRepo.getUsers())
            }
        }
    }
}