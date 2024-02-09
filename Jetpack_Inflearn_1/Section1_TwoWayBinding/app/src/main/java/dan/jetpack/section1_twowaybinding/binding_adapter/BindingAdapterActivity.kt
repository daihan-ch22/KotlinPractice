package dan.jetpack.section1_twowaybinding.binding_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import dan.jetpack.section1_twowaybinding.R

/**
 * BindingAdapter -> View에 속성을 맘대로 수정
 *
 * 1. 기존에 양방향 데이터 결합 / BindingAdapter 미사용
 * 2. 양방향 데이터 결합 / BindingAdapter 사용
 */
class BindingAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binding_adapter)

        var age: Int = 0
        val ageArea = findViewById<TextView>(R.id.ageArea_bindingAdapter)
        val imageArea = findViewById<ImageView>(R.id.imgArea_bindingAdapter)
        val plus = findViewById<Button>(R.id.plus_bindingAdapter)

        plus.setOnClickListener {
            age++

            ageArea.text = age.toString()

            if(age > 20){
                imageArea.setImageResource(R.drawable.download)
            }
        }
    }
}