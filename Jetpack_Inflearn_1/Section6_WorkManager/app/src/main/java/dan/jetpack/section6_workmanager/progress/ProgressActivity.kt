package dan.jetpack.section6_workmanager.progress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import dan.jetpack.section6_workmanager.R
import dan.jetpack.section6_workmanager.progress.ProgressWorkManagerTest.Companion.HowMuch

class ProgressActivity : AppCompatActivity() {

    private final val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        val workManagerTest = OneTimeWorkRequestBuilder<ProgressWorkManagerTest>().build()
        WorkManager.getInstance(this).enqueue(workManagerTest)

        //progress monitoring
        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workManagerTest.id)
            .observe(this, Observer { workInfo: WorkInfo? ->
                val progress = workInfo?.progress
                val value = progress?.getInt(HowMuch, 0)

                if(value != 0){
                    Log.d(TAG, value.toString())
                }
                if(value == 100){
                    Log.d(TAG, "FINISH!")
                }
            })
    }
}