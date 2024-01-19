package dan.jetpack.section6_workmanager.coroutine

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Coroutine_WorkManager2(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    private final val TAG = javaClass.simpleName

    override suspend fun doWork(): Result {

        //CoroutineWorker는 기본적으로 Dispatchers.Default로 되어있는데
        //withContext에서 설정 가능하다.
        withContext(Dispatchers.IO) {
            test1()
            test2()
        }

        return Result.success()
    }

    suspend fun test1() {
        for (i in 1..3) {
            delay(1000)
            Log.d(TAG, "test1 / ${i.toString()}")
        }
    }

    suspend fun test2() {
        for (i in 1..3) {
            delay(1000)
            Log.d(TAG, "test2 / ${i.toString()}")
        }
    }
}