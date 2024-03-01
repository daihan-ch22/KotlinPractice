package dan.jetpack.section8_paginglv3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dan.jetpack.section8_paginglv3.network.PassengerApi
import dan.jetpack.section8_paginglv3.network.RetrofitInstance
import dan.jetpack.section8_paginglv3.new_data.NewItems
import dan.jetpack.section8_paginglv3.new_network.GitHubApi
import dan.jetpack.section8_paginglv3.new_network.RetrofitInstanceNew
import kotlinx.coroutines.flow.Flow

class MainViewModel: ViewModel() {

    private val api = RetrofitInstanceNew.getInstance().create(GitHubApi::class.java)

    val items : Flow<PagingData<NewItems>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            MyPagingSource(api)
        }
    )
        .flow
        .cachedIn(viewModelScope)

}