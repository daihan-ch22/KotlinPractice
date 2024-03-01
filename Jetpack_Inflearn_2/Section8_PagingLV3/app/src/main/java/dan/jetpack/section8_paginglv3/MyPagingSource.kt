package dan.jetpack.section8_paginglv3

import android.util.Log
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import dan.jetpack.section8_paginglv3.network.PassengerApi
import dan.jetpack.section8_paginglv3.new_data.NewItems
import dan.jetpack.section8_paginglv3.new_network.GitHubApi
import kotlinx.coroutines.delay

private const val STARTING_KEY = 5

class MyPagingSource (
    private val gitHubApi : GitHubApi
) : PagingSource<Int, NewItems>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewItems> {
        val page = params.key ?: STARTING_KEY

        val response = gitHubApi.getData("android", page, params.loadSize)

        val data = response.items

        if( page != 1 ) {
            delay(2000)
        }

        return if (data == null) {
            LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = null
            )
        } else {
            LoadResult.Page(
                data = data,
                prevKey = if(page == 1) null else page-1,
                nextKey = page + ( params.loadSize / 30 )
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NewItems>): Int? {
        Log.d("getRefreshKey", "start")

        // Android Paging Library
        // 적당히 보고있는 페이지 position을 가져와서

        /**
         * Most recently accessed index in the list, including placeholders.
         *
         * `null` if no access in the [PagingData] has been made yet. E.g., if this snapshot was
         * generated before or during the first load.
         */
        val anchorPosition = state.anchorPosition

        // 적당히 보고있는 페이지를 찾아서 데이터를 받아옴

        // prevKey -> null -> 첫번째 페이지
        // nextKey -> null -> 마지막 페이지

        return anchorPosition?.let {
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}