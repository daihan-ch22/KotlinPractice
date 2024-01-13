package dan.jetpack.section5_room.SQLite1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import dan.jetpack.section5_room.R

class SQLite1Activity : AppCompatActivity() {

    lateinit var db : SQLiteHelperSample
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite1)

        db = SQLiteHelperSample(this)

        val inputArea = findViewById<EditText>(R.id.inputArea)
        val insertBtn = findViewById<Button>(R.id.insert)
        val getAllBtn = findViewById<Button>(R.id.getAll)
        val resultBtn = findViewById<TextView>(R.id.resultArea)
        val deleteBtn = findViewById<Button>(R.id.deleteAll)

        insertBtn.setOnClickListener {
            val inputText = inputArea.text.toString()
            db.insert(inputText)
            inputArea.setText("")
        }

        getAllBtn.setOnClickListener {
            val arr = db.getAllData()
            resultBtn.text = arr.toString()
        }

        deleteBtn.setOnClickListener {
            db.deleteAll()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}