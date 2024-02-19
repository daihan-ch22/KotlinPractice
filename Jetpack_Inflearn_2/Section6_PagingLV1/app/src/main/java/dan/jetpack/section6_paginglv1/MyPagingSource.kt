package dan.jetpack.section6_paginglv1

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

private const val STARTING_KEY = 1

class MyPagingSource: PagingSource<Int, User>() {

    private val TAG = javaClass.simpleName

    init {
        Log.d(TAG, "init")
    }

    // 새로고침을 누르면 어떻게 할 것인지
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null
    }

    // Paging 실행 시 어떻게 할 것인지
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {

        Log.d(TAG, "load")
        Log.d(TAG, "params.loadSize = ${params.loadSize.toString()}")
        Log.d(TAG, "params.key = ${params.key.toString()}")


        val page = params.key ?: STARTING_KEY
        Log.d(TAG, "page = ${page.toString()}")

        // 1.. 30*3  +30  +30  +30....
        val range = page.until(page + params.loadSize) //처음은 3배로 가져욤
        Log.d(TAG, "range = ${range.toString()}")

        // 첫 로드가 아닌 경우 3초씩 딜레이
        if(page != STARTING_KEY){
            delay(3000)
        }

        return LoadResult.Page<Int, User>(
            data = range.map { number ->
                User(
                    id = number,
                    userName = "UserNumber is $number"
                )
            },
            prevKey = null,
            nextKey = range.last + 1 //예: 마지막이 90 인 경우 다음 키는 91부터 시작해야 하니까 1 추가
        )
    }
}