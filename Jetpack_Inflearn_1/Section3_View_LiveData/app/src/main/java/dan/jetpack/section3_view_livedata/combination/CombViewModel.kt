package dan.jetpack.section3_view_livedata.combination

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap

class CombViewModel: ViewModel() {

    private var _mutableWord = MutableLiveData("")
    private var _randomMutableWord = MutableLiveData("")

    val liveWord : LiveData<String>
        get() = _mutableWord

    val randomLiveWord : LiveData<String>
        get() = _randomMutableWord

    val newData = liveWord.switchMap {
        getRandomWordShuffled(it)
    }

    init {
        getNextData()
    }

    fun getNextData(){
        val currentWord = testDataList.random() //get random word from testDataList

        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        _randomMutableWord.value = String(randomWord)
    }

    fun getRandomWordShuffled(word: String) : MutableLiveData<String> {
        val liveData = MutableLiveData("")
        val randomTextWord = word.toCharArray()
        randomTextWord.shuffle()
        liveData.value = String(randomTextWord)

        return liveData
    }
}