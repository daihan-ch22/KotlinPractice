package dan.jetpack.section1_twowaybinding.integrated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap

//4가지 -> BIG / MIDDLE / SMALL / VERY_SMALL
enum class MyPointType {
    BIG,
    MIDDLE,
    SMALL,
    VERY_SMALL
}

class IntegratedViewModel: ViewModel() {

    private var _point =  MutableLiveData(0)
    val point: LiveData<Int> = _point

    val myPointType: LiveData<MyPointType> = _point.switchMap { point ->
        MutableLiveData<MyPointType>().apply {
            value = when {
                point > 80 -> {
                    MyPointType.BIG
                }
                point > 50 -> {
                    MyPointType.MIDDLE
                }
                point > 30 -> {
                    MyPointType.SMALL
                }
                else -> {
                    MyPointType.VERY_SMALL
                }
            }
        }
    }


    fun plusPoint() {
        _point.value = point.value?.plus(10)
    }

}