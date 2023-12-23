package dan.jetpack.viewmodel.activity_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.viewmodel.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val plusBtn : Button = findViewById(R.id.plus)
        val minusBtn : Button = findViewById(R.id.minus)

        val resultArea : TextView = findViewById(R.id.result)
        resultArea.text = viewModel.countValue.toString()

        plusBtn.setOnClickListener {
            viewModel.plus()
            resultArea.text = viewModel.countValue.toString()
        }

        minusBtn.setOnClickListener {
            viewModel.minus()
            resultArea.text = viewModel.countValue.toString()
        }
    }
}