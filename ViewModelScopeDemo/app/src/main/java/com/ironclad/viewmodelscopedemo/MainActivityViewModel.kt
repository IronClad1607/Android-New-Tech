package com.ironclad.viewmodelscopedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    fun getUserData() {
        viewModelScope.launch {

        }
    }
}