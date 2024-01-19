package dan.jetpack.section6_workmanager.progress

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay

class ProgressWorkManagerTest(
    context: Context,
    parameters: WorkerParameters
): CoroutineWorker(
    context,
    parameters
) {

    companion object{
        const val HowMuch = "progress"
    }

    override suspend fun doWork(): Result {

        // i -> 1,2,3,4,5,6,7,8,9,10
        for(i in 1..10){

            val result = workDataOf(HowMuch to (i*10) )
            setProgress(result)

            delay(1000)
        }

        return Result.success()
    }
}