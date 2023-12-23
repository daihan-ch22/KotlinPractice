package dan.jetpack.viewmodel.fragment_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dan.jetpack.viewmodel.R

class FragmentActivity : AppCompatActivity() {

    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val transaction = manager.beginTransaction()
        val fragment = TestFragment()
        transaction.replace(R.id.frameArea, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}