package com.ironclad.coroutinesdemo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager1 {

    suspend fun getTotalUserData(): Int {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        }

        return 50
    }
}