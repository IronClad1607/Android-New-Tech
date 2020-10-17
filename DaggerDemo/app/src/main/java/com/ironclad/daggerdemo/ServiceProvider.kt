package com.ironclad.daggerdemo

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor(){
    init {
        Log.d("PUI", "Service Provider Constructed")
    }

    fun getServiceProvider() {
        Log.d("PUI", "Service Provider Connected")
    }
}