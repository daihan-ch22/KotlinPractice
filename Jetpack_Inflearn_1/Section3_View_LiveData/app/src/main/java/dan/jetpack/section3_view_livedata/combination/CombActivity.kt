package dan.jetpack.section3_view_livedata.combination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.section3_view_livedata.R
import dan.jetpack.section3_view_livedata.databinding.ActivityCombBinding

/**
 * Given name of fruit -> shuffle spellings
 * ViewModel + LiveData + LifeCycleOwner
 */
class CombActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCombBinding
    private lateinit var viewModel: CombViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_comb)
        viewModel = ViewModelProvider(this)[CombViewModel::class.java]

        binding.vm = viewModel //connect viewmodel with databinding
        binding.lifecycleOwner = this

        binding.next.setOnClickListener {
            viewModel.getNextData()
        }

        // 이번에는 viewMoodel.livework.observe..해서 연결해서 하지 않고 다이렉트로 뷰에 연결함
        // layout의 TextView를 바꿀건데 DataBinding써서 text속성을 @{vm.livedata} 식으로 한다

    }
}