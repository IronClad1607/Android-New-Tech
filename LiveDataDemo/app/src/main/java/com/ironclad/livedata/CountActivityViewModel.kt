package com.ironclad.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountActivityViewModel : ViewModel() {

    private var count = MutableLiveData<Int>()
    val countData: LiveData<Int>
        get() = count

    init {
        count.value = 0
    }

    fun updateValue() {
        count.value = (count.value)?.plus(1)
    }
}