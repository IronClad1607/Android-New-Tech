package com.ironclad.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    private var sum = MutableLiveData<Int>()
    val sumData: LiveData<Int>
        get() = sum

    init {
        sum.value = startingTotal
    }

    fun setNumbers(number: Int) {
        sum.value = (sum.value)?.plus(number)
    }
}