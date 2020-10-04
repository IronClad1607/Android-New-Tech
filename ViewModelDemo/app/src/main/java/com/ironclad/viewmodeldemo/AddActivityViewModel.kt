package com.ironclad.viewmodeldemo

import androidx.lifecycle.ViewModel

class AddActivityViewModel : ViewModel() {
    var sum = 0;

    fun addNumbers(number: Int): Int {
        sum += number
        return sum
    }
}