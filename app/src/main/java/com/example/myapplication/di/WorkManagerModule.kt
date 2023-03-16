package com.example.myapplication.di

import android.content.Context
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WorkManagerModule {

    @Singleton
    @Provides
    fun provideWorkerManager(context: Context) = WorkManager.getInstance(context)
}
