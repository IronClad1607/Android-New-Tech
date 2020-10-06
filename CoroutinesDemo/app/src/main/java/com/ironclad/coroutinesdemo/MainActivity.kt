package com.ironclad.coroutinesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }

        btnDownload.setOnClickListener {
            downloadUserData()
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.d("PUI", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}