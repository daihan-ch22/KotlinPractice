package dan.jetpack.section1_twowaybinding.binding_adapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BindingAdapterViewModel: ViewModel() {

    var mutableAge = MutableLiveData(0)

    fun plus() {
        mutableAge.value = mutableAge.value?.plus(1)
    }
}