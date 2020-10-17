package com.ironclad.daggerdemo

import android.util.Log
import javax.inject.Inject

class LiIonBattery @Inject constructor() : Battery {
    override fun getPower() {
        Log.d("PUI", "Power from Li-ion Battery")
    }
}