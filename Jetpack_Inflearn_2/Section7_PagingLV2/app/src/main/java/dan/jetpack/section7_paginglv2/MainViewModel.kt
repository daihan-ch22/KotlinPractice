package dan.jetpack.section7_paginglv2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dan.jetpack.section7_paginglv2.data.GithubResponseItem
import dan.jetpack.section7_paginglv2.network.GitApi
import dan.jetpack.section7_paginglv2.network.RetrofitInstance
import dan.jetpack.section7_paginglv2.paging.MyPagingSource
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {

    private val api = RetrofitInstance.getInstance().create(GitApi::class.java)

    val items : Flow<PagingData<GithubResponseItem>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            MyPagingSource(api)
        }
    )
        .flow
        .cachedIn(viewModelScope)

}