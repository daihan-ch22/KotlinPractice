package dan.jetpack.section5_room.room_1

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
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

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        Log.d("MainViewModel", db.textDao().getAllData().toString() )
        Log.d("MainViewModel", db.wordDao().getAllData().toString() )
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

