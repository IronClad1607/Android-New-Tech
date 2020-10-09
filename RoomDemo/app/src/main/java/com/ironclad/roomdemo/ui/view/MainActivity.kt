package com.ironclad.roomdemo.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ironclad.roomdemo.R
import com.ironclad.roomdemo.data.db.SubscriberDatabase
import com.ironclad.roomdemo.data.repo.SubscriberRepository
import com.ironclad.roomdemo.databinding.ActivityMainBinding
import com.ironclad.roomdemo.ui.viewmodels.SubscriberViewModel
import com.ironclad.roomdemo.ui.viewmodels.SubscriberViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(this).subscriberDao
        val repo = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repo)
        subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)

        binding.mViewModel = subscriberViewModel
        binding.lifecycleOwner = this

        displaySubscribersList()
    }

    private fun displaySubscribersList() {
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.d("PUI", it.toString())
        })
    }
}