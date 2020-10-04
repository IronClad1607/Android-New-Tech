package com.ironclad.livedata

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel(), Observable {
    private var sum = MutableLiveData<Int>()
    val sumData: LiveData<Int>
        get() = sum

    @Bindable
    val number = MutableLiveData<String>()

    init {
        sum.value = startingTotal
    }

    fun setNumbers() {
        val intNum = number.value!!.toInt()
        sum.value = (sum.value)?.plus(intNum)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}