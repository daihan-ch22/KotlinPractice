package dan.jetpack.section4_retrofit.Plants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dan.jetpack.section4_retrofit.Plants.adapter.CustomAdapter
import dan.jetpack.section4_retrofit.Plants.viewModel.MainViewModel
import dan.jetpack.section4_retrofit.R

class PlantMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_main)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getAllData()

        val rv = findViewById<RecyclerView>(R.id.plant_rv)

        viewModel.result.observe(this, Observer {
            val customAdapter = CustomAdapter(this, it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })
    }
}