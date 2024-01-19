package dan.jetpack.section6_workmanager.coroutine

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class Coroutine_WorkManager1(
    context: Context,
    workerParameters: WorkerParameters
): Worker(context, workerParameters) {

    override fun doWork(): Result {

        return Result.success()
    }
}