package dan.jetpack.section5_room.room_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dan.jetpack.section5_room.R
import dan.jetpack.section5_room.room_1.adapter.CustomAdapter
import dan.jetpack.section5_room.room_1.db.TextDatabase
import dan.jetpack.section5_room.room_1.entity.TextEntity
import dan.jetpack.section5_room.room_1.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Room_1_MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room1_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getData()

        val db = TextDatabase.getDatabase(this)

        val inputArea = findViewById<EditText>(R.id.room1_textInputArea)
        val insertBtn = findViewById<Button>(R.id.room1_insert)
        val getAllBtn = findViewById<Button>(R.id.room1_getData)
        val deleteBtn = findViewById<Button>(R.id.room1_delete)

        insertBtn.setOnClickListener {
            viewModel.insertData(inputArea.text.toString())
            inputArea.setText("")
        }

        val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.textList.observe(this, Observer {
            val customAdapter = CustomAdapter(it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })

        getAllBtn.setOnClickListener {
            viewModel.getData()
        }
        deleteBtn.setOnClickListener {
            viewModel.removeData()
        }

    }
}