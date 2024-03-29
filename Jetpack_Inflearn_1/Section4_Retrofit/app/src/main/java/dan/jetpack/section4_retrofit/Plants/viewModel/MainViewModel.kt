package dan.jetpack.section4_retrofit.Plants.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dan.jetpack.section4_retrofit.Plants.api.MyPlantApi
import dan.jetpack.section4_retrofit.Plants.api.RetrofitInstance
import dan.jetpack.section4_retrofit.Plants.model.Plant
import dan.jetpack.section4_retrofit.Plants.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

//    val retrofitInstance: MyPlantApi = RetrofitInstance.getInstance().create(MyPlantApi::class.java)

    private val repository = Repository()
    private val _result = MutableLiveData<List<Plant>>()
    val result: LiveData<List<Plant>>
        get() = _result

    fun getAllData() = viewModelScope.launch {
        Log.d("MainViewModel", repository.getAllData().toString())
        _result.value = repository.getAllData()
    }


}