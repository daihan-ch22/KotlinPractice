package dan.jetpack.section7_paginglv2.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import dan.jetpack.section7_paginglv2.data.GithubResponseItem
import dan.jetpack.section7_paginglv2.network.GitApi
import kotlinx.coroutines.delay

private const val STARTING_KEY = 1

class MyPagingSource (
    private val githubService : GitApi
) : PagingSource<Int, GithubResponseItem>() {

    private val TAG = javaClass.simpleName

    init {
        Log.d(TAG, "init")
    }
    override fun getRefreshKey(state: PagingState<Int, GithubResponseItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubResponseItem> {

        Log.d(TAG, "-----------------------------------")
        Log.d(TAG, "--------------START----------------")
        Log.d(TAG, "-----------------------------------")

        Log.d(TAG, "load")
        Log.d(TAG, "params.key : ${params.key}")

        val page = params.key ?: STARTING_KEY

        Log.d(TAG, "page : $page")

        val response = githubService.getData(page, params.loadSize)

        Log.d(TAG, "page : $response")
        Log.d(TAG, response.body().toString())

        val data = response.body()

        Log.d(TAG, "data : ${data.toString()}")

        if(page != 1){
            delay(1000)
        }

        Log.d(TAG, "params.loadSize = ${params.loadSize.toString()}")
        Log.d(TAG, "params.loadSize = ${(params.loadSize / 30).toString()}")

        return if(data != null) {
            LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = page + (params.loadSize / 10)
            )
        } else {
            LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = null
            )
        }

    }

}