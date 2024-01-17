package dan.jetpack.section6_workmanager.chaining

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class Chain_WorkManagerA(
    context: Context,
    workerParameters: WorkerParameters
): Worker(context, workerParameters) {

    private val TAG = javaClass.simpleName
    override fun doWork(): Result {

        for(i in 0..3){
            sleep(1000)
            Log.d(TAG, i.toString())
        }

        return Result.success()
    }
}