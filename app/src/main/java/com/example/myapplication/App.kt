package com.example.myapplication

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import com.example.myapplication.di.AppComponent
import com.example.myapplication.di.DaggerAppComponent
import timber.log.Timber

class App: Application() {
    lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        applicationComponent = DaggerAppComponent.factory().create(this)

        initWorkerFactory()
    }

    private fun initWorkerFactory() {
        val workerFactory = Configuration.Builder()
            .setWorkerFactory(applicationComponent.workerFactory())
            .build()

        WorkManager.initialize(this, workerFactory)
    }
}
