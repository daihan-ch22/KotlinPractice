package dan.jetpack.section9_paginglv4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewModelFactory(
    private val str : String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(str) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel Class")

    }
}