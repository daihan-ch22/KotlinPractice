package dan.jetpack.section9_paginglv4.state

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import dan.jetpack.section9_paginglv4.databinding.LoadStateItemBinding

class GithubLoadStateViewHolder(
    private val binding: LoadStateItemBinding,
    private val retry : () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(loadState : LoadState) {

        binding.retryBtn.isVisible = loadState is LoadState.Error
        binding.error.isVisible = loadState is LoadState.Error

        binding.loading.isVisible = loadState is LoadState.Loading

        binding.retryBtn.setOnClickListener {
            retry()
        }
    }
}