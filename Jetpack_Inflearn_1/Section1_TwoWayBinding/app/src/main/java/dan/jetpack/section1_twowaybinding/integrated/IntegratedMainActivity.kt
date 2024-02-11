package dan.jetpack.section1_twowaybinding.integrated

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.section1_twowaybinding.R
import dan.jetpack.section1_twowaybinding.databinding.ActivityIntegratedMainBinding

class IntegratedMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntegratedMainBinding
    private lateinit var viewModel: IntegratedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBindingInit()

    }

    private fun dataBindingInit(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_integrated_main)
        viewModel = ViewModelProvider(this)[IntegratedViewModel::class.java]

        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}