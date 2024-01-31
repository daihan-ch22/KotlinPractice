package dan.jetpack.section1_twowaybinding.intro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayBinding1ViewModel: ViewModel() {

    var mutableAge = MutableLiveData<Int>(0)

    fun plus(){
        mutableAge.value = mutableAge.value?.plus(1)
    }
}