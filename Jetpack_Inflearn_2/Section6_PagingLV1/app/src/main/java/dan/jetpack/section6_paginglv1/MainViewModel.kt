package dan.jetpack.section6_paginglv1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class MainViewModel: ViewModel() {

    val items: Flow<PagingData<User>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            MyPagingSource()
        }
    ).flow
        .cachedIn(viewModelScope) // viewmodel 범위에서 paging이 살아있을 수 있도록 캐싱 처리 (화면 가로처리 등..)

}