package com.ironclad.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ironclad.viewmodeldemo.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private lateinit var viewModel: AddActivityViewModel
    private lateinit var viewModelFactory: AddActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add)
        viewModelFactory = AddActivityViewModelFactory(0)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AddActivityViewModel::class.java)

        binding.tvSum.text = viewModel.sum.toString()

        binding.btnAdd.setOnClickListener {
            val number = binding.etNumber.text.toString().toInt()
            binding.etNumber.text.clear()
            binding.tvSum.text = viewModel.addNumbers(number).toString()
        }
    }
}