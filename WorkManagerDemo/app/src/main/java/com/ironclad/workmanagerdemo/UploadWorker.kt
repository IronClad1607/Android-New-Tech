package com.ironclad.workmanagerdemo

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            val count  = inputData.getInt(MainActivity.KEY,0)

            for (i in 0 until count) {
                Log.d("PUI", "Uploading  $i")
            }

            val time = SimpleDateFormat("dd/m/yyyy hh:mm:s")
            val currentDate = time.format(Date())

            val outputData = Data.Builder()
                .putString(KEY_WORKER,currentDate)
                .build()

            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }

    companion object{
        const val KEY_WORKER = "key_worker"
    }
}