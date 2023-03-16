package com.example.myapplication.di.worker

import androidx.work.ListenableWorker
import com.example.myapplication.SampleWorker
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkerKey(val value: KClass<out ListenableWorker>)

@Module
interface WorkerBindingModule {

    @Binds
    @IntoMap
    @WorkerKey(SampleWorker::class)
    fun bindSampleWorker(factory: SampleWorker.Factory): ChildWorkerFactory
}
