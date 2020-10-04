package com.ironclad.viewmodeldemo

import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ironclad.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.tvCount.text = viewModel.count.toString()

        binding.btnClick.setOnClickListener {
            binding.tvCount.text = viewModel.getUpdatedCount().toString()
        }

        binding.btnNext.setOnClickListener {
            val nextIntent = Intent(this, AddActivity::class.java)
            startActivity(nextIntent)
        }
    }
}