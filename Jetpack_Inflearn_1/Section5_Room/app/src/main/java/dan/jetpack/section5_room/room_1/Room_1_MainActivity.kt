package dan.jetpack.section5_room.room_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import dan.jetpack.section5_room.R
import dan.jetpack.section5_room.room_1.db.TextDatabase
import dan.jetpack.section5_room.room_1.entity.TextEntity
import dan.jetpack.section5_room.room_1.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Room_1_MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room1_main)

        val db = TextDatabase.getDatabase(this)

        val inputArea = findViewById<EditText>(R.id.room1_textInputArea)
        val insertBtn = findViewById<Button>(R.id.room1_insert)
        val getAllBtn = findViewById<Button>(R.id.room1_getData)
        val deleteBtn = findViewById<Button>(R.id.room1_delete)

        insertBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().insert(TextEntity(0,inputArea.text.toString()))
                db.wordDao().insert(WordEntity(0,inputArea.text.toString()))
                inputArea.setText("")
            }
        }
        getAllBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("MAINACTIVITY", db.textDao().getAllData().toString())
                Log.d("MAINACTIVITY", db.wordDao().getAllData().toString())

            }
        }
        deleteBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAllData()
                db.wordDao().deleteAllData()
            }
        }



    }
}