package dan.jetpack.viewmodel.sharing_viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import dan.jetpack.viewmodel.R
import dan.jetpack.viewmodel.databinding.FragmentSharingTestBinding
import dan.jetpack.viewmodel.databinding.FragmentTestBinding

class SharingTestFragment : Fragment() {

    private val viewModel: SharingMainViewModel by activityViewModels()
    private lateinit var binding: FragmentSharingTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sharing_test, container, false)
        binding.sharingFragmentTest.text = viewModel.countValue.toString()

        return binding.root
    }

}