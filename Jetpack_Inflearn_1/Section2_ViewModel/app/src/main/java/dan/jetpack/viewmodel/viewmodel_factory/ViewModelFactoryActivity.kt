package dan.jetpack.viewmodel.viewmodel_factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.viewmodel.R

class ViewModelFactoryActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_factory)
        viewModelFactory = MainViewModelFactory(5000)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }
}