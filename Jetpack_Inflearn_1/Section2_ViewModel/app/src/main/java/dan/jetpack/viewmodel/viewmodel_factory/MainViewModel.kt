package dan.jetpack.viewmodel.viewmodel_factory

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(
    num: Int
) : ViewModel() {

    init {
        Log.d("MainViewModel", "num = ${num.toString()}")
    }

    // 네트워크 통신이나 Local DB에서 ViewModel로 데이터를 넘길 때
    // 값을 넘기면서 ViewModel을 인스턴스화 하는걸로 이해함
    // ViewModelFactory를 사용한다.

}