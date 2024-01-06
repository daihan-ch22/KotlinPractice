package dan.jetpack.section3_view_livedata.combination

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CombViewModel: ViewModel() {

    private var _mutableWord = MutableLiveData("")
    val liveWord : LiveData<String>
        get() = _mutableWord

    fun getNextData(){
        val currentWord = testDataList.random() //get random word from testDataList

        _mutableWord.value = currentWord
    }
}