package dan.jetpack.section3_view_livedata.map_switchmap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap

class MainViewModel: ViewModel() {

    // Transformations -> map / switchMap

    // map -> 값을 return

    private var _mutableCount = MutableLiveData(0)
    val liveCount: LiveData<Int>
        get() = _mutableCount

    val mapLiveData = liveCount.map {
        it + it
    }

    val switchMapLiveData = liveCount.switchMap {
        changeValue(it)
    }

    fun setLiveDataValue(count: Int){
        _mutableCount.value = count
    }

    fun changeValue(count: Int): MutableLiveData<Int>{
        val testLiveData = MutableLiveData(count * count)
        return testLiveData
    }
}