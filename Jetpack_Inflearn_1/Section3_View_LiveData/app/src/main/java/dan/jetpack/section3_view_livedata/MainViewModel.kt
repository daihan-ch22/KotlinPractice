package dan.jetpack.section3_view_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// keyword: MutableLiveData vs LiveData

class MainViewModel: ViewModel() {

    private var _testMutableLiveData = MutableLiveData(0)

    val testLiveData : LiveData<Int>
        get() = _testMutableLiveData


    fun plusLiveDataValue(){
            _testMutableLiveData.value = _testMutableLiveData.value?.plus(1)
        }



//    fun useMutableLiveData(){
//        var testMutableLiveData = MutableLiveData(0)
//
//        fun plusLiveDataValue(){
//            testMutableLiveData.value = testMutableLiveData.value?.plus(1)
//        }
//    }
}