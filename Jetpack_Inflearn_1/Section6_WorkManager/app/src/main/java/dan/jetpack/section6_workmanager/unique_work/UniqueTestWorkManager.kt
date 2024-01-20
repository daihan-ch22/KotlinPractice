package dan.jetpack.section6_workmanager.unique_work

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class UniqueTestWorkManager(
    context: Context,
    parameters: WorkerParameters
): CoroutineWorker(
    context,
    parameters
) {
    private final val TAG = javaClass.simpleName

    override suspend fun doWork(): Result {
        Log.d(TAG, "START")

        for(i in 0..3){
            Log.d(TAG, i.toString())
            delay(1000)
        }

        Log.d(TAG, "END")

        return Result.success()
    }
}