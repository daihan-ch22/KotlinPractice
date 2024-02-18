package layout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dan.jetpack.section4_room_techniques.datastore.MyDataStore
import kotlinx.coroutines.launch

class DataStoreViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val myDataStore = MyDataStore(application)

    fun insert(userName: String) = viewModelScope.launch {
        myDataStore.insertUserName(userName)
    }

    val read = myDataStore.getUserName.asLiveData()

}