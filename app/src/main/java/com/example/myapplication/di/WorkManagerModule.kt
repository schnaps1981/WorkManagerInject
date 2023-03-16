package com.example.myapplication.di

import android.content.Context
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WorkManagerModule {

    @Singleton
    @Provides
    fun provideWorkerManager(@ApplicationContext context: Context) =
        WorkManager.getInstance(context)
}
