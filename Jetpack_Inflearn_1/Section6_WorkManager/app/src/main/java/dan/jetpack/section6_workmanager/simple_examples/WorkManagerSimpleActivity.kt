package dan.jetpack.section6_workmanager.simple_examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import dan.jetpack.section6_workmanager.R

/**
 * 앱을 종료해도 지속이 필요한 작업일때 사용 가능 (작업이 예약된 채로 유지)
 * 지연 가능한 백그라운드 작업 (Coroutine 지원)
 * 작업 순서 설정할때
 */
class WorkManagerSimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager_simple)

        //WorkManager 실행부
//        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
//        WorkManager.getInstance(this).enqueue(workManagerA)

        //key-value
        val myData: Data = workDataOf(
            "a" to 10,
            "b" to 20
        )

        // WorkManager 값 전달
        val simpleWorkManagerB = OneTimeWorkRequestBuilder<Simple_WorkManagerB>()
            .setInputData(myData)
            .build()
        WorkManager.getInstance(this).enqueue(simpleWorkManagerB)

        // WorkManager 결과 값 수신
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(simpleWorkManagerB.id)
            .observe(this, Observer { info ->
                if(info != null && info.state.isFinished){
                    val result = info.outputData.getInt("result", 10000)
                    val result2 = info.outputData.getInt("result2", 10000)
                    Log.d("MainActivity", result.toString())
                    Log.d("MainActivity", result2.toString())
                }
            })
    }
}