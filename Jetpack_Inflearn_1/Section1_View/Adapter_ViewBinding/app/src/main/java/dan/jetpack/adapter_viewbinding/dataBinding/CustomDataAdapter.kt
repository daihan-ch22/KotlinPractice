package dan.jetpack.adapter_viewbinding.dataBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dan.jetpack.adapter_viewbinding.R
import dan.jetpack.adapter_viewbinding.databinding.TextRowItemBinding

class CustomDataAdapter(
    private val dataSet : ArrayList<String>
) : RecyclerView.Adapter<CustomDataAdapter.ViewHolder>() {

    /**
     * ViewHolder Class
     */
    class ViewHolder(binding : TextRowItemBinding) : RecyclerView.ViewHolder(binding.root){
        val myText: TextView = binding.myText
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        /**
         * inflater
         * – The LayoutInflater used to inflate the binding layout.
         *
         * layoutId
         * – The layout resource ID of the layout to inflate.
         *
         * parent
         * – Optional view to be the parent of the generated hierarchy (if attachToParent is true),
         * or else simply an object that provides a set of LayoutParams values for root of the returned hierarchy
         * (if attachToParent is false.)
         *
         * attachToParent
         * – Whether the inflated hierarchy should be attached to the parent parameter.
         * If false, parent is only used to create the correct subclass of LayoutParams for the root view in the XML.
         */
        val view = DataBindingUtil.inflate<TextRowItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.text_row_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myText.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}