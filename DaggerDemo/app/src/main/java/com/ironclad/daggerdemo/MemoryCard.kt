package com.ironclad.daggerdemo

import android.util.Log

class MemoryCard {
    init {
        Log.d("PUI", "Memory Card Constructed")
    }

    fun getSpaceAvailability() {
        Log.d("PUI", "Memory Space Available")
    }
}