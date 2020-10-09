package com.ironclad.roomdemo.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ironclad.roomdemo.R
import com.ironclad.roomdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}