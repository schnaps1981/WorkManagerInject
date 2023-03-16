package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.MainActivity
import com.example.myapplication.di.worker.AppWorkerFactory
import com.example.myapplication.di.worker.WorkerBindingModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        WorkerBindingModule::class,
        RepositoryModule::class,
        WorkManagerModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)

    fun workerFactory(): AppWorkerFactory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}