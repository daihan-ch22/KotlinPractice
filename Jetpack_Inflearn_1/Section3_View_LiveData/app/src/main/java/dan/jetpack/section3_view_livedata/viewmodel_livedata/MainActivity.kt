package dan.jetpack.section3_view_livedata.viewmodel_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.section3_view_livedata.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        findViewById<Button>(R.id.btnArea).setOnClickListener {
            viewModel.plusLiveDataValue()
        }

        viewModel.testLiveData.observe(this, Observer {
            findViewById<TextView>(R.id.textArea).text = it.toString()
        })

    }

    fun useMutableLiveData(){
//        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//
//        findViewById<Button>(R.id.btnArea).setOnClickListener {
//            viewModel.plusLiveDataValue()
//        }
//
//        viewModel.testMutableLiveData.observe(this, Observer {
//            //findViewById<TextView>(R.id.textArea).text = viewModel.testMutableLiveData.value.toString()
//            findViewById<TextView>(R.id.textArea).text = it.toString()
//        })
    }
}