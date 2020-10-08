package com.ironclad.viewmodelscopedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ironclad.viewmodelscopedemo.repo.UserRepo
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel : ViewModel() {
    private var userRepo = UserRepo()
//    var users = MutableLiveData<ArrayList<User>>()

//    fun getUserData() {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                users.postValue(userRepo.getUsers())
//            }
//        }
//    }

    var users = liveData(Dispatchers.IO) {
        val result = userRepo.getUsers()
        emit(result)
    }
}