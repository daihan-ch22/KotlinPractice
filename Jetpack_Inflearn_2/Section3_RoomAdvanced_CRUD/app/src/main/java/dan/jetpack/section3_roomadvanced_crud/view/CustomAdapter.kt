package dan.jetpack.section3_roomadvanced_crud.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dan.jetpack.section3_roomadvanced_crud.R
import dan.jetpack.section3_roomadvanced_crud.db.entity.NumberEntity

class CustomAdapter(
    private val dataSet : ArrayList<NumberEntity>
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ItemClick {
        fun onClick(
            view: View,
            position: Int
        )
    }

    var updateClick : ItemClick? = null
    var deleteClick : ItemClick? = null

    class ViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val idArea: TextView
        val randomNumber: TextView

        init {
            idArea = view.findViewById(R.id.id)
            randomNumber = view.findViewById(R.id.randomNum)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idArea.text = dataSet[position].id.toString()
        holder.randomNumber.text = dataSet[position].randomNumber.toString()

        holder.itemView.findViewById<Button>(R.id.update).setOnClickListener { v ->
            updateClick?.onClick(v, position)
        }

        holder.itemView.findViewById<Button>(R.id.delete).setOnClickListener { v ->
            deleteClick?.onClick(v, position)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}