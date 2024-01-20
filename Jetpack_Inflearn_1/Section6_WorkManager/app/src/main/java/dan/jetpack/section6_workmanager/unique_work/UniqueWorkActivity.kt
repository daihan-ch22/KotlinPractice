package dan.jetpack.section6_workmanager.unique_work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import dan.jetpack.section6_workmanager.R

class UniqueWorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unique_work)

        val testBtn = findViewById<Button>(R.id.uniqueWMButton)

        testBtn.setOnClickListener {
            unique()
        }
    }

    //새 방식 (unique한 workmanager 작업) - 여러번 클릭해도 한번만
    // KEEP - 작업 끝날때까지 하나만
    // REPLACE - 기존 작업 날리고 새 작업 시작
    fun unique(){
        val testWorkManager = OneTimeWorkRequestBuilder<UniqueTestWorkManager>().build()
        WorkManager.getInstance(this).enqueueUniqueWork(
            "test",
            ExistingWorkPolicy.KEEP,
            testWorkManager
        )
    }

    //기존 (버튼 여러번 클릭시 WM이 여러번 돌아감
    fun asIs(){
        val testWorkManager = OneTimeWorkRequestBuilder<UniqueTestWorkManager>().build()
        WorkManager.getInstance(this).enqueue(testWorkManager)
    }
}