package dan.jetpack.section9_paginglv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dan.jetpack.section9_paginglv4.state.GithubLoadStateAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.simpleName
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var githubAdapter: GithubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        githubAdapter = GithubAdapter()

        val str = intent.getStringExtra("inputText").toString()

        loadData(str)

//        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//
//        val rv = findViewById<RecyclerView>(R.id.rv)
//        val githubAdapter = GithubAdapter()
//
//        rv.layoutManager = LinearLayoutManager(this)
//        rv.adapter = githubAdapter
//
//        lifecycleScope.launch {
//            viewModel.items.collect() {
//                githubAdapter.submitData(it)
//            }
//        }

    }

    private fun loadData(str: String) {

        viewModelFactory = MainViewModelFactory(str)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
//        rv.adapter = githubAdapter

        rv.adapter = githubAdapter.withLoadStateFooter(
            GithubLoadStateAdapter {
                githubAdapter.retry()
            }
        )

        lifecycleScope.launch {
            viewModel.items.collect() {
                githubAdapter.submitData(it)
            }
        }
    }

}