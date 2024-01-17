package dan.jetpack.section6_workmanager.simple_examples

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class Simple_WorkManagerA(
    context: Context,
    workerParameters: WorkerParameters,
): Worker(context, workerParameters) {

    override fun doWork(): Result {
        for(i in 1..10){
            sleep(1000)
            Log.d("WorkManagerA", i.toString())
        }
        return Result.success()
    }
}