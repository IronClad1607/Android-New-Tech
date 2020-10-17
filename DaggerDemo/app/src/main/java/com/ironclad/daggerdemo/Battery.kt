package com.ironclad.daggerdemo

import android.util.Log
import javax.inject.Inject

class Battery @Inject constructor() {
    init {
        Log.d("PUI","Battery Constructed")
    }

    fun getPower(){
        Log.d("PUI","Battery power is avaliable")
    }
}