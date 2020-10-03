package com.ironclad.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnSubmit)
        button.setOnClickListener {
            displayGreeting()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayGreeting() {
        val messageView = findViewById<TextView>(R.id.tvGreetings)
        val nameText = findViewById<EditText>(R.id.etName)

        messageView.text = "Hello! ${etName.text}"
    }
}