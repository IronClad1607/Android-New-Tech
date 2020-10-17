package com.ironclad.daggerdemo

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(val memorySize: Int) {

    @Provides
    fun providesMemoryCard(): MemoryCard {
        Log.d("PUI","MemorySize: $memorySize")
        return MemoryCard()
    }
}