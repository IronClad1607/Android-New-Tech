package com.ironclad.asyncandawaitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            Log.d("PUI", "Calculation Started!!")
            val stock1 = async(Dispatchers.IO) {
                getStock1()
            }

            val stock2 = async(Dispatchers.IO) {
                getStock2()
            }
            val total = stock1.await() + stock2.await()

            Toast.makeText(applicationContext, "Total:$total", Toast.LENGTH_SHORT).show()
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