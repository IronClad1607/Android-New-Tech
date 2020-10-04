package com.ironclad.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    var sum = MutableLiveData<Int>()

    init {
        sum.value = startingTotal
    }

    fun setNumbers(number: Int) {
        sum.value = (sum.value)?.plus(number)
    }
}