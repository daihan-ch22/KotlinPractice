package dan.jetpack.section2_room_coroutineflow.room_flow_listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dan.jetpack.section2_room_coroutineflow.R
import dan.jetpack.section2_room_coroutineflow.databinding.ActivityCrudactivityBinding
import dan.jetpack.section2_room_coroutineflow.room_flow_listadapter.db.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.IndexOutOfBoundsException

class CRUDActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrudactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrudactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MyDatabase.getDatabase(this)

        val recyclerView = binding.userRV
        val myListAdapter = MyListAdapter()

        recyclerView.adapter = myListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.read.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().getAllDataWithFlow().collect() {
                    withContext(Dispatchers.Main) {
                        myListAdapter.submitList(it)
                    }
                }
            }
        }

        binding.update.setOnClickListener {
            val id = binding.id.text.toString().toInt()
            CoroutineScope(Dispatchers.IO).launch {
                val result = db.userDao().getAllData()
                try {
                    val userEntity = result[id]
                    userEntity.name = "updated id"
                    userEntity.age = 0
                    db.userDao().update(userEntity)
                } catch (e : IndexOutOfBoundsException){
                    e.printStackTrace()
                }
            }
        }

        binding.remove.setOnClickListener {
            val id = binding.id.text.toString().toInt()
            CoroutineScope(Dispatchers.IO).launch {
                val result = db.userDao().getAllData()
                try {
                    val userEntity = result[id]
                    db.userDao().delete(userEntity)
                } catch (e : IndexOutOfBoundsException){
                    e.printStackTrace()
                }
            }
        }

    }
}