package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var workManager: WorkManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            startWorker()
        }
    }

    private fun startWorker() {

        val workTag = "${SampleWorker.TAG}_${Random.nextInt()}"

        val stateWork = OneTimeWorkRequest.Builder(SampleWorker::class.java)
            .addTag(workTag)
            .build()

        workManager.enqueueUniqueWork(workTag, ExistingWorkPolicy.KEEP, stateWork)
    }
}
