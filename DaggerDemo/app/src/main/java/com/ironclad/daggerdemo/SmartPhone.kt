package com.ironclad.daggerdemo

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmartPhone @Inject constructor(val battery: Battery, val simCard: SIMCard, val memoryCard: MemoryCard) {
    init {
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailability()
        Log.d("PUI", "Smart Phone Constructed")
    }

    fun makeACallWithRecording() {
        Log.d("PUI", "Calling...")
    }
}