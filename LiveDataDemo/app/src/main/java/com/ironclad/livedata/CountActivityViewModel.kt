package com.ironclad.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountActivityViewModel : ViewModel() {

    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun updateValue() {
        count.value = (count.value)?.plus(1)
    }
}