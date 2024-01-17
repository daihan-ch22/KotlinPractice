package dan.jetpack.section5_room.room_1

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dan.jetpack.section5_room.room_1.db.TextDatabase
import dan.jetpack.section5_room.room_1.entity.TextEntity
import dan.jetpack.section5_room.room_1.entity.WordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel에서 Context가 필요하다 -> application: Application 받고
 * viewModel상속을 AndroidViewModel(application)으로 받음
 *
 * 또는 확장함수 사용 가능 val AndroidViewModel.context: Context
 *                      get() = getApplication<Application>().applicationContext
 */
class MainViewModel(application: Application): AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    val db = TextDatabase.getDatabase(context)

    private var _textList = MutableLiveData<List<TextEntity>>()
    val textList: LiveData<List<TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList: LiveData<List<WordEntity>>
        get() = _wordList

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        Log.d("MainViewModel", db.textDao().getAllData().toString() )
        Log.d("MainViewModel", db.wordDao().getAllData().toString() )

        // BackGrond Thread에서 값을 set 하려면 .value가 아니라 .postValue로 넣어야 한다.
        _textList.postValue(db.textDao().getAllData())
        _wordList.postValue(db.wordDao().getAllData())
    }

    fun insertData(text: String) = viewModelScope.launch(Dispatchers.IO){
        db.textDao().insert(TextEntity(0,text))
        db.wordDao().insert(WordEntity(0,text))
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().deleteAllData()
        db.wordDao().deleteAllData()
        context
    }

}

