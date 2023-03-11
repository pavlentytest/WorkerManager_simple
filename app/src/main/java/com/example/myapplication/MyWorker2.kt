package com.example.myapplication

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker2(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        val key1 = inputData.getString("key1")
        val key2 = inputData.getInt("key2",0)
        Log.d("RRR","MyWorker 2 started! $key1 $key2")
        Thread.sleep(3000)
        Log.d("RRR","MyWorker 2 completed! $key1, $key2")
        return Result.success()
    }
}