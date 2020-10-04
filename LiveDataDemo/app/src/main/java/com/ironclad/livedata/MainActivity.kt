package com.ironclad.livedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ironclad.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(0)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        viewModel.sumData.observe(this, Observer {
            binding.tvSum.text = it.toString()
        })

        binding.btnAdd.setOnClickListener {
            val number = binding.etNumber.text.toString().toInt()
            binding.etNumber.text.clear()
            viewModel.setNumbers(number)
        }

        binding.btnNext.setOnClickListener {
            val nextIntent = Intent(this, CountActivity::class.java)
            startActivity(nextIntent)
        }
    }
}