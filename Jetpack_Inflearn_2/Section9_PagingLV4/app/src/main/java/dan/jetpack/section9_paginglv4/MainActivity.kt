package dan.jetpack.section9_paginglv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.simpleName
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val rv = findViewById<RecyclerView>(R.id.rv)
        val githubAdapter = GithubAdapter()

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = githubAdapter

        lifecycleScope.launch {
            viewModel.items.collect() {
                githubAdapter.submitData(it)
            }
        }


//        val string = intent.getStringExtra("inputText")
//        Log.d(TAG, "inputTextFromIntent ? == $string")
    }
}