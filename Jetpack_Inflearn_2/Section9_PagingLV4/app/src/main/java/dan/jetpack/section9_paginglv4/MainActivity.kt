package dan.jetpack.section9_paginglv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val string = intent.getStringExtra("inputText")
        Log.d(TAG, "inputTextFromIntent ? == $string")
    }
}