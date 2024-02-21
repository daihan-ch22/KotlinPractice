package dan.jetpack.section8_paginglv3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dan.jetpack.section8_paginglv3.network.PassengerApi
import dan.jetpack.section8_paginglv3.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class MainViewModel: ViewModel() {

    private val api = RetrofitInstance.getInstance().create(PassengerApi::class.java)

    val items : Flow<PagingData<Data>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            MyPagingSource(api)
        }
    )
        .flow
        .cachedIn(viewModelScope)

}