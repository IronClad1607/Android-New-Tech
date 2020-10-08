package com.ironclad.livecyclescopedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.ironclad.livecyclescopedemo.ui.main.HomeFragment
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }

        lifecycleScope.launch(Dispatchers.IO) {
            Log.d("PUI", "Thread is: ${Thread.currentThread().name}")
        }
    }
}