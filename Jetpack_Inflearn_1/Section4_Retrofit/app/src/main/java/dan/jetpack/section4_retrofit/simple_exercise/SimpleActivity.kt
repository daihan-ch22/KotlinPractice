package dan.jetpack.section4_retrofit.simple_exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.section4_retrofit.R
import dan.jetpack.section4_retrofit.simple_exercise.viewmodel.SimpleMainViewModel


class SimpleActivity : AppCompatActivity() {

    private lateinit var viewModel : SimpleMainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        viewModel = ViewModelProvider(this)[SimpleMainViewModel::class.java]
        viewModel.getPost1()
        viewModel.getPostNumber(3)

        val area1 = findViewById<TextView>(R.id.area1)
        val area2 = findViewById<TextView>(R.id.area2)

        viewModel.liveWord1.observe(this, Observer {
            area1.text = it.toString()
        })

        viewModel.liveWord2.observe(this, Observer {
            area2.text = it.toString()
        })

    }
}