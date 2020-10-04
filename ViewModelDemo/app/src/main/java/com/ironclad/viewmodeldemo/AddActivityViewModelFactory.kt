package com.ironclad.viewmodeldemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class AddActivityViewModelFactory(private val startingTotal: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddActivityViewModel::class.java)) {
            return AddActivityViewModel(startingTotal) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}