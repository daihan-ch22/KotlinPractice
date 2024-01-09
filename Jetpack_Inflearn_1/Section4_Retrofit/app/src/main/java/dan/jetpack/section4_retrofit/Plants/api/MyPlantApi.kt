package dan.jetpack.section4_retrofit.Plants.api

import dan.jetpack.section4_retrofit.Plants.model.Plant
import retrofit2.http.GET

interface MyPlantApi {

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants(): List<Plant>


}