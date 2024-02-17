package dan.jetpack.section2_room_coroutineflow.room_flow_listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dan.jetpack.section2_room_coroutineflow.R
import dan.jetpack.section2_room_coroutineflow.databinding.ActivityRoomFlowListAdaptBinding
import dan.jetpack.section2_room_coroutineflow.room_flow_listadapter.db.MyDatabase
import dan.jetpack.section2_room_coroutineflow.room_flow_listadapter.db.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomFlowListAdaptActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRoomFlowListAdaptBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomFlowListAdaptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MyDatabase.getDatabase(this)

        val recyclerView = binding.userRV
        val myListAdapter = MyListAdapter()

        recyclerView.adapter = myListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val name = binding.name.text.toString()
                val age = binding.age.text.toString()
                val userEntity = UserEntity(0, name, age.toInt())
                db.userDao().insert(userEntity)
            }
        }

        binding.get.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().getAllDataWithFlow().collect() {
                    withContext(Dispatchers.Main){
                        myListAdapter.submitList(it)
                    }
                }
            }
        }
    }
}