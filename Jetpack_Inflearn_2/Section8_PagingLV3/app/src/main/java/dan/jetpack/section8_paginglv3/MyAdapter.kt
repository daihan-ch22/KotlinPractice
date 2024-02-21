package dan.jetpack.section8_paginglv3

import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load

class MyAdapter : PagingDataAdapter<Data, MyAdapter.MyViewHolder>(DIFF_CALLBACK) {


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Data>() {

            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MyViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        val imgArea = view.findViewById<ImageView>(R.id.imageArea)
        val textArea = view.findViewById<TextView>(R.id.textArea)

        fun bind(item: Data) {
            textArea.text = item._id
            imgArea.load(item.airline[0].logo)
        }

    }


    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        val item = getItem(position)

        if(item != null){
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return MyViewHolder(view)
    }
}