package dan.jetpack.section3_view_livedata.fragment_livedata

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dan.jetpack.section3_view_livedata.R
import dan.jetpack.section3_view_livedata.databinding.FragmentBlank1Binding

class BlankFragment1 : Fragment() {

    private val TAG = "BlankFragment1"

    private var _binding : FragmentBlank1Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: BlankViewModel1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentBlank1Binding.inflate(inflater, container, false)
        var view = binding.root

        viewModel = ViewModelProvider(this)[BlankViewModel1::class.java]

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            viewModel.plusCountValue()
        }

        //Fragment와 View의 생명주기가 다르기 때문에 this가 아닌 viewLifeCycleOwner 사용한다.
        viewModel.liveCount.observe(viewLifecycleOwner, Observer {
            binding.text1.text = it.toString()
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}