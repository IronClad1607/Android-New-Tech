package com.ironclad.viewmodeldemo

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var count = 0

    fun getUpdatedCount(): Int {
        return ++count
    }
}