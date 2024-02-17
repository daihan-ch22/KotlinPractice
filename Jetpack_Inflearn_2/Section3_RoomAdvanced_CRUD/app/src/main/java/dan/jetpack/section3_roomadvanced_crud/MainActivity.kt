package dan.jetpack.section3_roomadvanced_crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dan.jetpack.section3_roomadvanced_crud.db.entity.NumberEntity
import dan.jetpack.section3_roomadvanced_crud.view.CustomAdapter
import dan.jetpack.section3_roomadvanced_crud.view.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
    lateinit var numberArrayList: ArrayList<NumberEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // CREATE
        val createBtn = findViewById<Button>(R.id.create)
        createBtn.setOnClickListener {
            val randomNumber = (0..100).random().toString()
            val numberEntity = NumberEntity(0,randomNumber)
            viewModel.create(numberEntity)
        }

        val numberRV = findViewById<RecyclerView>(R.id.numberRV)


        // READ
        viewModel.read()
        viewModel.numberEntityList.observe(this, Observer {
            Log.d("MAIN", it.toString())

            numberArrayList = it as ArrayList<NumberEntity>
            val customAdapter = CustomAdapter(numberArrayList)
            numberRV.adapter = customAdapter

            onClickEventHandling(customAdapter)
        })

        numberRV.layoutManager = LinearLayoutManager(this)

    }

    private fun onClickEventHandling(customAdapter: CustomAdapter) {

        // UPDATE
        customAdapter.updateClick = object : CustomAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                viewModel.update(numberArrayList[position])
            }
        }


        // DELETE
        customAdapter.deleteClick = object : CustomAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Snackbar.make(view, numberArrayList[position].toString(), Snackbar.LENGTH_LONG).show()
                viewModel.delete(numberArrayList[position])
            }
        }

    }

}