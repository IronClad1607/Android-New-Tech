package com.ironclad.daggerdemo

import android.util.Log
import javax.inject.Inject

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