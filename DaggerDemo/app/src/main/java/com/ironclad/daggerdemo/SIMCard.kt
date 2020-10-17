package com.ironclad.daggerdemo

import android.util.Log

class SIMCard(private val serviceProvider: ServiceProvider) {
    init {
        Log.d("PUI", "SIM Card Constructed")
    }

    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}