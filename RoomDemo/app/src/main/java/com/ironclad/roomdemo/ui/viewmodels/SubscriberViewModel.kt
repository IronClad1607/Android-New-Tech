package com.ironclad.roomdemo.ui.viewmodels

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironclad.roomdemo.data.model.Subscriber
import com.ironclad.roomdemo.data.repo.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repo: SubscriberRepository) : ViewModel(), Observable {

    val subscribers = repo.subscribers

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "ClearAll"
    }

    fun saveOrUpdate() {
        val name = inputName.value!!
        val email = inputEmail.value!!

        insert(Subscriber(0, name, email))
        inputName.value = null
        inputEmail.value = null
    }

    fun clearAllOrDelete() {
        clearAll()
    }

    fun insert(subscriber: Subscriber) = viewModelScope.launch {
        repo.insert(subscriber)
    }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        repo.update(subscriber)
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repo.delete(subscriber)
    }

    fun clearAll() = viewModelScope.launch {
        repo.deleteAll()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}