package com.ironclad.notificationsdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val channelID = "channel1"
    private var notificationManager: NotificationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelID, "Demo", "This is a Demo Channel")
        btnClick.setOnClickListener {
            displayNotification()
        }
    }

    private fun displayNotification() {
        val notificationID = 4
        val tapIntent = Intent(this, SecondActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(
                this,
                0,
                tapIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
        val notification = NotificationCompat.Builder(this, channelID)
            .setContentTitle("Demo Title")
            .setContentText("This is a demo notification")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager?.notify(notificationID, notification)
    }

    private fun createNotificationChannel(id: String, name: String, mDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH).apply {
                description = mDescription
            }

            notificationManager?.createNotificationChannel(channel)
        }
    }
}