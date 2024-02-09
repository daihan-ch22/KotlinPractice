class BindingAdapterViewModel : ViewModel() {

    var mutableAge = MutableLive(0)

    fun plus() {

        mutableAge.value

    }
}