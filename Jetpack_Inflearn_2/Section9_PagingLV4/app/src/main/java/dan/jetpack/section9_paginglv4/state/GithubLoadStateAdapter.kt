package dan.jetpack.section9_paginglv4.state

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import dan.jetpack.section9_paginglv4.databinding.LoadStateItemBinding

class GithubLoadStateAdapter(
    private val retry : () -> Unit
) : LoadStateAdapter<GithubLoadStateViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): GithubLoadStateViewHolder {

        val view = LoadStateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubLoadStateViewHolder(view, retry)
    }


    override fun onBindViewHolder(holder: GithubLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

}