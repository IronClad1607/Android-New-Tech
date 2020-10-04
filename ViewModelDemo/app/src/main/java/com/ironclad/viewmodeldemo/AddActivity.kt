package com.ironclad.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ironclad.viewmodeldemo.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }
}