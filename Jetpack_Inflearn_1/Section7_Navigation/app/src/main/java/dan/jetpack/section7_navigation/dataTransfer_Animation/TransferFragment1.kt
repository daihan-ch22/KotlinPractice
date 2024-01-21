package dan.jetpack.section7_navigation.dataTransfer_Animation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import dan.jetpack.section7_navigation.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TransferFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */

// Safe Args 사용
class TransferFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        val bundle = Bundle()
//        bundle.putString("key", "value")

        val view = inflater.inflate(R.layout.fragment_transfer1, container, false)

        //Safe Args사용 시 데이터를 안넘기게 되면 default값이 찍히게 된다.
//        val action = TransferFragment1Directions.actionTransferFragment1ToTransferFragment2("abcdef")
        val action = TransferFragment1Directions.actionTransferFragment1ToTransferFragment2("abcdef")

        view.findViewById<Button>(R.id.transfer_btn1).setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.action_transferFragment1_to_transferFragment2, bundle)
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TransferFragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransferFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}