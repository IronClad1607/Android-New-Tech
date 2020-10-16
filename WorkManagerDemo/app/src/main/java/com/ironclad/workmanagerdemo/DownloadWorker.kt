package com.ironclad.workmanagerdemo

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class DownloadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            for (i in 0..3000) {
                Log.d("PUI", "Downloading $i")
            }

            val time = SimpleDateFormat("dd/m/yyyy hh:mm:s")
            val currentDate = time.format(Date())
            Log.d("PUI", "Completed: $currentDate")
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}