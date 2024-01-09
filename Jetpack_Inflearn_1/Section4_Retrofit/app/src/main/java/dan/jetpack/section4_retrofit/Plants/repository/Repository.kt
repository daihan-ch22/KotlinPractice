package dan.jetpack.section4_retrofit.Plants.repository

import dan.jetpack.section4_retrofit.Plants.api.MyPlantApi
import dan.jetpack.section4_retrofit.Plants.api.RetrofitInstance

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyPlantApi::class.java)

    suspend fun getAllData() = client.getAllPlants()
}