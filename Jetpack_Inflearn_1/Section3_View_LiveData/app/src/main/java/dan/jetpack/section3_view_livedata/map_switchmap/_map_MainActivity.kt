package dan.jetpack.section3_view_livedata.map_switchmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.section3_view_livedata.R
import dan.jetpack.section3_view_livedata.databinding.MapActivityMainBinding

class _map_MainActivity : AppCompatActivity() {

    private lateinit var binding : MapActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout._map_activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.liveCount.observe(this, Observer {
            //binding.resultArea1.text = (it + it).toString()
            //binding.resultArea2.text = (it * it).toString()
        })

        viewModel.mapLiveData.observe(this, Observer {
            binding.resultArea1.text = it.toString()
        })

        viewModel.switchMapLiveData.observe(this, Observer {
            binding.resultArea2.text = it.toString()
        })

        binding.btnArea.setOnClickListener {
            val count = binding.inputArea.text.toString().toInt()
            viewModel.setLiveDataValue(count)
        }
    }
}