package dan.jetpack.section1_twowaybinding.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.section1_twowaybinding.R
import dan.jetpack.section1_twowaybinding.databinding.ActivityTwoWayBinding1Binding
import org.w3c.dom.Text

//양방향 데이터 결합 (Two Way Binding)
// 데이터와 뷰를 직접 연결하여 서로 영향을 준다.

// 1. 기존방식: Activity에서 View와 연결해서 사용
// 2. 양뱡향 방식: ViewModel <-> Activity <-> XML
//            : ViewModel <-> XML
class TwoWayBinding1 : AppCompatActivity() {

    private lateinit var binding: ActivityTwoWayBinding1Binding
    private lateinit var viewModel: TwoWayBinding1ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoWayBinding1Binding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TwoWayBinding1ViewModel::class.java]
        setContentView(binding.root)

        binding.vm = viewModel
        binding.lifecycleOwner = this


//        1번 방식
//        var age = 0
//        val ageArea = findViewById<TextView>(R.id.ageArea)
//        val plusBtn = findViewById<Button>(R.id.plusBtn)
//
//        plusBtn.setOnClickListener {
//            age++
//            ageArea.text = age.toString()
//        }
    }
}