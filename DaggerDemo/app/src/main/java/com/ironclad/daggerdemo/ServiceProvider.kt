package com.ironclad.daggerdemo

import android.util.Log

class ServiceProvider {
    init {
        Log.d("PUI", "Service Provider Constructed")
    }

    fun getServiceProvider() {
        Log.d("PUI", "Service Provider Connected")
    }
}