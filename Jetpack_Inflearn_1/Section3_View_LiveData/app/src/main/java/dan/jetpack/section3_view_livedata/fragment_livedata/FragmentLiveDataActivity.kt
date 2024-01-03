package dan.jetpack.section3_view_livedata.fragment_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dan.jetpack.section3_view_livedata.R
import dan.jetpack.section3_view_livedata.databinding.ActivityFragmentLiveDataBinding

class FragmentLiveDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentLiveDataBinding

    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val transaction1 = manager.beginTransaction()
            val fragment1 = BlankFragment1()
            transaction1
                .replace(R.id.frameArea, fragment1)
                .addToBackStack(null)
                .commit()
        }

        binding.btn2.setOnClickListener {
            val transaction2 = manager.beginTransaction()
            val fragment2 = BlankFragment2()
            transaction2
                .replace(R.id.frameArea, fragment2)
                .addToBackStack(null)
                .commit()
        }
    }
}