package dan.jetpack.viewmodel.activity_viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

//아주 간단한 예제로 LiveData와 같이 씀
class MainViewModel : ViewModel() {

    var countValue = 0

    init {
        Log.d("MainViewModel", "init")
    }

    fun plus(){
        countValue++
        Log.d("MainViewModel", countValue.toString())
    }

    fun minus(){
        countValue--
        Log.d("MainViewModel", countValue.toString())
    }

    fun getCount(): Int {
        return countValue
    }

}