package dan.jetpack.section2_room_coroutineflow.listadapter_diffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dan.jetpack.section2_room_coroutineflow.R
import org.w3c.dom.Text

class CatListAdapter : ListAdapter<CatDataModel, CatListAdapter.CatViewHolder>(DiffCallback) {

    // DiffUtil
    // List의 데이터 값이 같은지 다른지 비교해주는 Util 클래스
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<CatDataModel>() {
            override fun areItemsTheSame(oldItem: CatDataModel, newItem: CatDataModel): Boolean {
                // 고유값 비교
                return oldItem.catId == newItem.catId
            }

            override fun areContentsTheSame(oldItem: CatDataModel, newItem: CatDataModel): Boolean {
                // 내용 비교
                return oldItem == newItem
            }

        }
    }

    class CatViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(
        view
    ) {
        val catId = view.findViewById<TextView>(R.id.catId)
        val catName = view.findViewById<TextView>(R.id.catName)
        val catAge = view.findViewById<TextView>(R.id.catAge)

        fun bind(item : CatDataModel){
            catId.text = item.catId.toString()
            catName.text = item.catName
            catAge.text = item.catAge.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}