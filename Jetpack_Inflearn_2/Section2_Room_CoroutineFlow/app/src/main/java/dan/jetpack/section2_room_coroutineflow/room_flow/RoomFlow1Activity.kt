package dan.jetpack.section2_room_coroutineflow.room_flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import dan.jetpack.section2_room_coroutineflow.R
import dan.jetpack.section2_room_coroutineflow.room_flow.db.TextDatabase
import dan.jetpack.section2_room_coroutineflow.room_flow.db.TextEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 1. FLOW를 사용하지 않을 때 (Room Flow - 살펴보기 1)
 * 2. FLOW를 사용할 때 (Room Flow - 살펴보기 2)
 */
class RoomFlow1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_flow1)

        val inputArea = findViewById<EditText>(R.id.flow1_textInputArea)
        val insertBtn = findViewById<Button>(R.id.flow1_insert)
        val getAllBtn = findViewById<Button>(R.id.flow1_getData)
        val deleteBtn = findViewById<Button>(R.id.flow1_delete)

        val resultArea = findViewById<TextView>(R.id.flow_resultArea)
        val db = TextDatabase.getDatabase(this)

        insertBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val text = TextEntity(0, inputArea.text.toString())
                db.textDao().insert(text)
                inputArea.setText("")
            }
        }

        getAllBtn.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val resultText = db.textDao().getAllData().toString()
                withContext(Dispatchers.Main) {
                    resultArea.text = resultText
                }
            }
        }

        deleteBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAllData()
            }
        }

    }
}