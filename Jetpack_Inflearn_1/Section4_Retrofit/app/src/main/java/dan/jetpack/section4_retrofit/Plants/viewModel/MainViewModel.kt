package dan.jetpack.section4_retrofit.Plants.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dan.jetpack.section4_retrofit.Plants.api.MyApi
import dan.jetpack.section4_retrofit.Plants.api.RetrofitInstance
import dan.jetpack.section4_retrofit.Plants.model.Plant
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val retrofitInstance: MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val _result = MutableLiveData<List<Plant>>()
    val result: LiveData<List<Plant>>
        get() = _result

    fun getAllData() = viewModelScope.launch {
        Log.d("MainViewModel", retrofitInstance.getAllPlants().toString())
        _result.value = retrofitInstance.getAllPlants()
    }


}