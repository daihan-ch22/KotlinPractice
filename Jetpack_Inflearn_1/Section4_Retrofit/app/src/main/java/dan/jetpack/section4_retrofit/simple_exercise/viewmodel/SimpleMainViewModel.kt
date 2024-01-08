package dan.jetpack.section4_retrofit.simple_exercise.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dan.jetpack.section4_retrofit.simple_exercise.api.MyApi
import dan.jetpack.section4_retrofit.simple_exercise.api.RetrofitInstance
import dan.jetpack.section4_retrofit.simple_exercise.model.Post
import kotlinx.coroutines.launch

class SimpleMainViewModel: ViewModel() {

    private final val TAG = "SimpleMainViewModel"

    // get retrofit instance
    private val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)

    // livedata
    private var _mutableWord1 = MutableLiveData<String>()
    val liveWord1 : LiveData<String>
        get() = _mutableWord1

    private var _mutableWord2 = MutableLiveData<String>()
    val liveWord2 : LiveData<String>
        get() = _mutableWord2

    // RecyclerView
    private var _mutableWordList = MutableLiveData<List<Post>>()
    val liveWordList : LiveData<List<Post>>
        get() = _mutableWordList

    fun getPost1() = viewModelScope.launch {
        val post = retrofitInstance.getPost1()
        //Log.d(TAG, post.toString())
        _mutableWord1.value = post.title
    }

    fun getPostNumber(number : Int) = viewModelScope.launch {
        val post = retrofitInstance.getPostNumber(number)
        //Log.d(TAG, post.toString())
        _mutableWord2.value = post.title
    }

    // all posts
    fun getPostAll() = viewModelScope.launch {
        val postAll = retrofitInstance.getPostAll()
        //Log.d(TAG, postAll.toString())

        _mutableWordList.value = postAll
    }
}