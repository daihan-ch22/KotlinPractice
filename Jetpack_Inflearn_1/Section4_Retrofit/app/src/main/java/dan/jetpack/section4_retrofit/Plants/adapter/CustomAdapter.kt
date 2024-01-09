package dan.jetpack.section4_retrofit.Plants.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dan.jetpack.section4_retrofit.Plants.model.Plant
import dan.jetpack.section4_retrofit.R

class CustomAdapter(
    val context: Context,
    val dataSet: List<Plant>
): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(
        view: View
    ): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.plant_textArea)
        val imageView: ImageView = view.findViewById(R.id.plant_imageArea)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_text_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text = dataSet[position].name

        Glide.with(context)
            .load(dataSet[position].imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}