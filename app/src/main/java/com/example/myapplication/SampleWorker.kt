package com.example.myapplication

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myapplication.repository.SampleRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class SampleWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val params: WorkerParameters,
    private val sampleRepository: SampleRepository
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {

        Timber.d("Sample repo get random INT = ${sampleRepository.getRandom()}")

        return Result.success()
    }

    companion object {
        val TAG: String = SampleWorker::class.java.simpleName
    }
}
