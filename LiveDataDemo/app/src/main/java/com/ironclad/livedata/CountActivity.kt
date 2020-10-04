package com.ironclad.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ironclad.livedata.databinding.ActivityCountBinding

class CountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountBinding
    private lateinit var viewModel: CountActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_count)
        binding.mViewModel = viewModel
        viewModel = ViewModelProvider(this).get(CountActivityViewModel::class.java)

        viewModel.count.observe(this, Observer {
            binding.tvCount.text = it.toString()
        })

        binding.btnClick.setOnClickListener {
            viewModel.updateValue()
        }
    }
}