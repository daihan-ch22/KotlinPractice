package dan.jetpack.section8_paginglv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val rv = findViewById<RecyclerView>(R.id.rv)
        val myAdapter = MyAdapter()

        lifecycleScope.launch {
            viewModel.items.collect() {
                myAdapter.submitData(it)
            }
        }

        val loadingNext = findViewById<TextView>(R.id.loadingNext)
        val loadingPrev = findViewById<TextView>(R.id.loadingPrev)

        lifecycleScope.launch {
            myAdapter.loadStateFlow.collect() {

                val isLoadingNext = it.source.append is LoadState.Loading
                loadingNext.isVisible = isLoadingNext

                val isLoadingPrev = it.source.append is LoadState.Loading
                loadingPrev.isVisible = isLoadingPrev
            }
        }
    }
}