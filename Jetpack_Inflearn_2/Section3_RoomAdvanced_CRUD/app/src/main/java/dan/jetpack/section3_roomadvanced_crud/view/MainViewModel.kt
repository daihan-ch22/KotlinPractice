package dan.jetpack.section3_roomadvanced_crud.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dan.jetpack.section3_roomadvanced_crud.db.entity.NumberEntity
import dan.jetpack.section3_roomadvanced_crud.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = Repository()
    lateinit var numberEntityList : LiveData<List<NumberEntity>>


    fun create(
        numberEntity: NumberEntity
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.create(numberEntity)
        }
    }

    fun read() {
        numberEntityList = repository.read().asLiveData()
    }

    fun update(
        numberEntity: NumberEntity
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val randomNumber = (0..100).random().toString()
            numberEntity.randomNumber = "updated : $randomNumber"

            repository.update(numberEntity)
        }
    }

    fun delete(
        numberEntity: NumberEntity
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(numberEntity)
        }
    }

}