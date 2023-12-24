package dan.jetpack.viewmodel.sharing_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.viewmodel.R
import dan.jetpack.viewmodel.databinding.ActivitySharingMainBinding

class SharingMainActivity : AppCompatActivity() {

    lateinit var binding: ActivitySharingMainBinding
    lateinit var viewModel: SharingMainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sharing_main)
        viewModel = ViewModelProvider(this)[SharingMainViewModel::class.java]
        setContentView(binding.root)

        binding.resultArea.text = viewModel.getCount().toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.resultArea.text = viewModel.getCount().toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.resultArea.text = viewModel.getCount().toString()
        }

        val manager = supportFragmentManager

        binding.showFragment.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = SharingTestFragment()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}