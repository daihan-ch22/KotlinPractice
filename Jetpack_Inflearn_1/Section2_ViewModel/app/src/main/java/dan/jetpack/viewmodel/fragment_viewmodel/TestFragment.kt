package dan.jetpack.viewmodel.fragment_viewmodel

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import dan.jetpack.viewmodel.R
import dan.jetpack.viewmodel.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private final val TAG = "TestFragment"
    private lateinit var binding: FragmentTestBinding
    private lateinit var viewModel : TestFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)

        viewModel = ViewModelProvider(this)[TestFragmentViewModel::class.java]

        binding.resultArea.text = viewModel.getCount().toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.resultArea.text = viewModel.getCount().toString()
        }

        binding.minus.setOnClickListener {
            viewModel.countValue
            binding.resultArea.text = viewModel.getCount().toString()
        }

        return binding.root
    }

}