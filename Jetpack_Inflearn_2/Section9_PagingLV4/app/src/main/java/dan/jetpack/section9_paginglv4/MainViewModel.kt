package dan.jetpack.section9_paginglv4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dan.jetpack.section9_paginglv4.data.Items
import dan.jetpack.section9_paginglv4.network.GitApi
import dan.jetpack.section9_paginglv4.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {

    private val api = RetrofitInstance.getInstance().create(GitApi::class.java)

    val items : Flow<PagingData<Items>> = Pager (
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            GithubPagingSource(api, "android")
        }
    )
        .flow
        .cachedIn(viewModelScope)

}