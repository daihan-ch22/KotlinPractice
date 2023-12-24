package dan.jetpack.viewmodel.sharing_viewmodel

import androidx.lifecycle.ViewModel

class SharingMainViewModel : ViewModel() {

    var countValue = 0

    fun plus() {
        countValue++
    }

    fun minus() {
        countValue--
    }

    fun getCount() : Int {
        return countValue
    }
}