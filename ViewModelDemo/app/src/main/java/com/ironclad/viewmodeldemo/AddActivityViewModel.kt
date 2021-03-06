package com.ironclad.viewmodeldemo

import androidx.lifecycle.ViewModel

class AddActivityViewModel(startingTotal: Int) : ViewModel() {
    var sum = 0;

    init {
        sum = startingTotal
    }

    fun addNumbers(number: Int): Int {
        sum += number
        return sum
    }
}