package dan.jetpack.section6_workmanager.periodic

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PeriodicWorkManager1(
    context: Context,
    parameters: WorkerParameters
): Worker(
    context,
    parameters
) {

    private final val TAG = javaClass.simpleName
    override fun doWork(): Result {
        Log.d(TAG, "doWork()")

        val format = SimpleDateFormat("hh:mm:ss", Locale.KOREA)
        val currentTime = format.format(Date())

        Log.d(TAG, currentTime)

        return Result.success()
    }
}