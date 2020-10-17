package com.ironclad.daggerdemo

import android.util.Log

class Battery {
    init {
        Log.d("PUI","Battery Constructed")
    }

    fun getPower(){
        Log.d("PUI","Battery power is avaliable")
    }
}