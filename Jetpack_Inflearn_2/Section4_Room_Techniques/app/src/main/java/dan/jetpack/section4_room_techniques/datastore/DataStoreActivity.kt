package dan.jetpack.section4_room_techniques.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.section4_room_techniques.R
import layout.DataStoreViewModel

class DataStoreActivity : AppCompatActivity() {

    private lateinit var viewModel: DataStoreViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_store)

        viewModel = ViewModelProvider(this)[DataStoreViewModel::class.java]

        val save1 = findViewById<Button>(R.id.save1)
        save1.setOnClickListener {
            val editText1 = findViewById<EditText>(R.id.editText1)

            val insertText = editText1.text.toString()
            viewModel.insert(insertText)
        }

        val read1 = findViewById<Button>(R.id.read1)
        read1.setOnClickListener {
            val readText1 = findViewById<TextView>(R.id.readText1)

            viewModel.read.observe(this, Observer {
                readText1.text = it.toString()
            })

        }
    }
}