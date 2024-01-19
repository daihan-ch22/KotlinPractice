package dan.jetpack.section6_workmanager.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import dan.jetpack.section6_workmanager.R

class CoroutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        val workManager = OneTimeWorkRequestBuilder<Coroutine_WorkManager2>().build()
        WorkManager.getInstance(this).enqueue(workManager)
    }
}