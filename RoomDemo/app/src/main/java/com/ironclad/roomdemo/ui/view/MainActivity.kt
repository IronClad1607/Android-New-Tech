package com.ironclad.roomdemo.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ironclad.roomdemo.R
import com.ironclad.roomdemo.data.db.SubscriberDatabase
import com.ironclad.roomdemo.data.model.Subscriber
import com.ironclad.roomdemo.data.repo.SubscriberRepository
import com.ironclad.roomdemo.databinding.ActivityMainBinding
import com.ironclad.roomdemo.ui.adaters.SubscriberAdapter
import com.ironclad.roomdemo.ui.viewmodels.SubscriberViewModel
import com.ironclad.roomdemo.ui.viewmodels.SubscriberViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    private lateinit var mAdapter: SubscriberAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(this).subscriberDao
        val repo = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repo)
        subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)

        binding.mViewModel = subscriberViewModel
        binding.lifecycleOwner = this

        initRecyclerView()
        subscriberViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView() {
        mAdapter = SubscriberAdapter { selectedItem: Subscriber ->
            listItemClicked(
                selectedItem
            )
        }
        binding.rvSubscribers.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }
        displaySubscribersList()
    }

    private fun displaySubscribersList() {
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.d("PUI", it.toString())
            mAdapter.setList(it)
            mAdapter.notifyDataSetChanged()
        })
    }

    private fun listItemClicked(subscriber: Subscriber) {
//        Toast.makeText(this, "Selected Name: ${subscriber.name}", Toast.LENGTH_SHORT).show()
        subscriberViewModel.initUpdateAndDelete(subscriber)
    }
}