package dan.jetpack.section4_retrofit.coroutine_vmscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import dan.jetpack.section4_retrofit.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineWithVMScopeActivity : AppCompatActivity() {

    //간단한 코루틴 + ViewModelScope
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_with_vmscope)

        val goToSecond = findViewById<Button>(R.id.goToSecond)
        goToSecond.setOnClickListener {
            val intent = Intent(this, CouritineWithVMScopeSecondActivity::class.java)
            startActivity(intent)
        }

//        Log.d("TEST", "START")
//        CoroutineScope(Dispatchers.IO).launch {
//            Log.d("TEST", "CouritineScope START")
//            a()
//            b()
//            Log.d("TEST", "CouritineScope START")
//        }
//        Log.d("TEST", "END")
    }

    suspend fun a() {
        delay(1000)
        Log.d("TEST", "AP1")

        delay(1000)
        Log.d("TEST", "AP2")
    }

    suspend fun b() {
        delay(1000)
        Log.d("TEST", "BP1")

        delay(1000)
        Log.d("TEST", "BP2")
    }
}