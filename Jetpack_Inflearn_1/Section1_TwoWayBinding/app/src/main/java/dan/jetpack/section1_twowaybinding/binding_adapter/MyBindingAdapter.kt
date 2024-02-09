package dan.jetpack.section1_twowaybinding.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import dan.jetpack.section1_twowaybinding.R

@BindingAdapter("myAge")
fun myAgeSetting(view: TextView, age: Int){
    if(age > 20){
        view.text = "${age.toString()} 보다 많음"
    } else {
        view.text = age.toString()
    }
}

@BindingAdapter("myImg")
fun myImageSetting(view: ImageView, age: Int) {
    if(age > 20){
        view.setImageResource(R.drawable.download)
    }
}