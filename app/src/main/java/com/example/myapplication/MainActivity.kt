package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)

        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val data: Data = Data.Builder().putString("key1","Hello").build()

        val worker = OneTimeWorkRequestBuilder<MyWorker>().setInputData(data).build()
        val worker2 = OneTimeWorkRequestBuilder<MyWorker2>().build()

        val list: ArrayList<WorkRequest> = ArrayList()
        list.add(worker)
        list.add(worker2)

        button.setOnClickListener {

            // паралелльно
            //WorkManager.getInstance(this)
            //    .enqueue(list)
            // последовательно
            WorkManager.getInstance(this)
                .beginWith(worker)
                .then(worker2)
                .enqueue()

        }
    }
}