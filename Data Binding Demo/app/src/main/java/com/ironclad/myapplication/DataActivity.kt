package com.ironclad.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ironclad.myapplication.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data)
        val student = getStudent()
    }


    private fun getStudent(): Student {
        return Student(1, "IronClad", "abc@gmail.com")
    }
}