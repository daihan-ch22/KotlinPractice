package dan.jetpack.section6_workmanager.simple_examples

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

/**
 * WorkManager로 Data 주고받기
 */
class Simple_WorkManagerB(
    context: Context,
    workerParameters: WorkerParameters
): Worker(context, workerParameters) {
    private val TAG = javaClass.simpleName

    override fun doWork(): Result {

        // Data 받는 부분 (값이 안들어오면 default)
        val a = inputData.getInt("a", 1000)
        val b = inputData.getInt("b", 2000)
        val c = inputData.getInt("c", 3000)

        Log.d(TAG, a.toString())
        Log.d(TAG, b.toString())
        Log.d(TAG, c.toString())

        //결과 값 반환
        val output : Data = workDataOf(
            "result" to 10
        )

        return Result.success(output)
    }
}