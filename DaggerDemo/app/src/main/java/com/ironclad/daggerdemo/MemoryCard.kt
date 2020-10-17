package com.ironclad.daggerdemo

import android.util.Log
import javax.inject.Inject

class MemoryCard @Inject constructor() {
    init {
        Log.d("PUI", "Memory Card Constructed")
    }

    fun getSpaceAvailability() {
        Log.d("PUI", "Memory Space Available")
    }
}