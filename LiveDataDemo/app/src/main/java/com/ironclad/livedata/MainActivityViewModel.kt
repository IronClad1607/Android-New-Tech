package com.ironclad.livedata

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    var sum = 0;

    init {
        sum = startingTotal
    }

    fun addNumbers(number: Int): Int {
        sum += number
        return sum
    }
}