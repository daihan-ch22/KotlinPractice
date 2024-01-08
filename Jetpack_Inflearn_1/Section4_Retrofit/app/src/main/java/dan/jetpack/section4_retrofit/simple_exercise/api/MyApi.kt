package dan.jetpack.section4_retrofit.simple_exercise.api

import dan.jetpack.section4_retrofit.simple_exercise.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

    @GET("posts/1")
    suspend fun getPost1() : Post

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number : Int
    ) : Post
}