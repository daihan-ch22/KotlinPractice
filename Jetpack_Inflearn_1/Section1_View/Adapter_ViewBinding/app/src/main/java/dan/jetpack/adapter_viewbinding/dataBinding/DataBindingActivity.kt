package dan.jetpack.adapter_viewbinding.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dan.jetpack.adapter_viewbinding.R
import dan.jetpack.adapter_viewbinding.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        val view = binding.root
        setContentView(view)

        val array = ArrayList<String>()

        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")

        val customDataAdapter = CustomDataAdapter(array)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = customDataAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}