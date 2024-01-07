package dan.jetpack.section4_retrofit.coroutine_vmscope

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CouritineWithVMScopeViewModel: ViewModel() {

    fun a() {
        CoroutineScope(Dispatchers.IO).launch {
            for(i in 1..10){
                delay(1000)
                Log.d("ViewModelScope A", i.toString())
            }
        }
    }

    //뷰모델 사용 시 viewModelScope 사용함
    fun b() {
        viewModelScope.launch {
            for(i in 1..10){
                delay(1000)
                Log.d("ViewModelScope B", i.toString())
            }
        }
    }
}