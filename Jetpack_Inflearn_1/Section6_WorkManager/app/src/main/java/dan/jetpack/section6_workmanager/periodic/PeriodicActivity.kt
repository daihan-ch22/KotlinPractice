package dan.jetpack.section6_workmanager.periodic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import dan.jetpack.section6_workmanager.R
import java.util.concurrent.TimeUnit

//주기적 실행 (Periodic WorkManager)
// 15분마다, 30분마다, 1시간마다 등
class PeriodicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_periodic)

        // Minimum 15 minutes
        val workManager = PeriodicWorkRequestBuilder<PeriodicWorkManager1>(15, TimeUnit.MINUTES).build()

        WorkManager.getInstance(this).enqueue(workManager)
    }
}