package dan.jetpack.section7_navigation.dataTransfer_Animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dan.jetpack.section7_navigation.R

class DataTransferMainActivity : AppCompatActivity() {

    // 첫번째 A / 두번째 B

    // 1. enterAnim: A -> B 갈때 B가 보이는 방식
    // 2. exitAnim: A -> B 갈때 A가 사라지는 방식
    // 3. popEnterAnim: 뒤로 가기로 B -> A로 올때 A가 나타나는 방식
    // 4. popExitAnim: 뒤로 가기로 B -> A로 올때 B가 사라지는 방식


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_transfer_main)
    }
}