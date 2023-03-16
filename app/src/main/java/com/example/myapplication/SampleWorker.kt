package com.example.myapplication

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myapplication.di.worker.ChildWorkerFactory
import com.example.myapplication.repository.SampleRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import timber.log.Timber

class SampleWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val params: WorkerParameters,
    private val sampleRepository: SampleRepository
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {

        Timber.d("Sample repo get random INT = ${sampleRepository.getRandom()}")

        return Result.success()
    }

    @AssistedFactory
    interface Factory : ChildWorkerFactory {
        override fun create(context: Context, params: WorkerParameters): SampleWorker
    }

    companion object {
        val TAG: String = SampleWorker::class.java.simpleName
    }
}
