package dan.jetpack.section4_retrofit.coroutine_vmscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.section4_retrofit.R

class CouritineWithVMScopeSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_couritine_with_vmscope_second)

        val vm = ViewModelProvider(this)[CouritineWithVMScopeViewModel::class.java]
        vm.a()
        vm.b()

    }
}