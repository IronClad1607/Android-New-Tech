package com.ironclad.asyncandawaitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            Log.d("PUI", "Calculation Started!!")
            val stock1 = async { getStock1() }
            val stock2 = async { getStock2() }
            val total = stock1.await() + stock2.await()
            Log.d("PUI", "Total: $total")
        }
    }

    private suspend fun getStock1(): Int {
        delay(10000)
        Log.d("PUI", "Stock 1 returned")
        return 55000
    }

    private suspend fun getStock2(): Int {
        delay(8000)
        Log.d("PUI", "Stock 2 returned")
        return 35000
    }
}