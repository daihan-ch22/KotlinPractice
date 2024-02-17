package dan.jetpack.section3_roomadvanced_crud.repository

import dan.jetpack.section3_roomadvanced_crud.MyApp
import dan.jetpack.section3_roomadvanced_crud.db.MyDatabase
import dan.jetpack.section3_roomadvanced_crud.db.entity.NumberEntity
import kotlinx.coroutines.flow.Flow

class Repository {

    private val context = MyApp.context()
    private val db = MyDatabase.getDatabase(context)

    fun create(
        numberEntity: NumberEntity
    ) {
        db.numberDao().create(numberEntity)
    }

    fun read(): Flow<List<NumberEntity>> {
        return db.numberDao().read()
    }

    fun update(
        numberEntity: NumberEntity
    ) {
        db.numberDao().update(numberEntity)
    }

    fun delete(
        numberEntity: NumberEntity
    ) {
        db.numberDao().delete(numberEntity)
    }

}