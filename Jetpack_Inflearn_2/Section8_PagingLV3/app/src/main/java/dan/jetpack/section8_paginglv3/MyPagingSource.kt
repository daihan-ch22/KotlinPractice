package dan.jetpack.section8_paginglv3

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dan.jetpack.section8_paginglv3.network.PassengerApi
import kotlinx.coroutines.delay

private const val STARTING_KEY = 5

class MyPagingSource (
    private val passengerApi : PassengerApi
) : PagingSource<Int, Data>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val page = params.key ?: STARTING_KEY

        val response = passengerApi.getData(page, params.loadSize)

        val data = response.body()?.data

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

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return null
    }

}