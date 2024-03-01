package dan.jetpack.section8_paginglv3.new_network

import dan.jetpack.section8_paginglv3.new_data.GitHubResponse
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.github.com/search/repositories?q=android&page=1&per_page=90

interface GitHubApi {

    @GET("search/repositories")
    suspend fun getData (

        @Query("q")
        query : String,

        @Query("page")
        page : Int,

        @Query("per_page")
        per_page : Int

    ) : GitHubResponse

}