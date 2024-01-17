package dan.jetpack.section6_workmanager.chaining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import dan.jetpack.section6_workmanager.R

/**
 * WorkManager Chaining
 *
 * A -> 순서 상관 없이 실행 ok
 * B -> 순서 상관 없이 실행 ok
 * C -> 무조건 A/B 모두 실행 후 실행되야한다.
 */
class WorkManagerChainingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager_chaining)

        val workManagerA = OneTimeWorkRequestBuilder<Chain_WorkManagerA>().build()
        val workManagerB = OneTimeWorkRequestBuilder<Chain_WorkManagerB>().build()
        val workManagerC = OneTimeWorkRequestBuilder<Chain_WorkManagerC>().build()

//        WorkManager.getInstance(this).enqueue(workManagerA)
//        WorkManager.getInstance(this).enqueue(workManagerB)
//        WorkManager.getInstance(this).enqueue(workManagerC)

        WorkManager.getInstance(this)
            .beginWith(listOf(workManagerA, workManagerB)) //A,B부터 시작
            .then(workManagerC)             //그리고 C 시작
            .enqueue()
    }
}