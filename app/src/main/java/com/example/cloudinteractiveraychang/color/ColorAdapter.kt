package com.example.cloudinteractiveraychang.color

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import com.example.cloudinteractiveraychang.R
import com.example.cloudinteractiveraychang.data.Colors
import com.example.cloudinteractiveraychang.network.VolleyService
import com.example.cloudinteractiveraychang.util.Util

class ColorAdapter(private val colorData: List<Colors>,
                   private val onClickListener: OnClickListener
) : RecyclerView.Adapter<ColorAdapter.mViewHolder>() {

    inner class mViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.tvId)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val background : NetworkImageView = itemView.findViewById(R.id.ivBackground)

        fun bind(item: Colors) {
            id.text = item.id.toString()
            title.text = item.title
            val splitThumbnailUrl = Util.splitUrl(item.thumbnailUrl,"/")
            val textColor = "?f=#E8E8E4"
            background.setDefaultImageResId(R.color.white)
            background.setImageUrl(
                "https://ipsumimage.appspot.com/${splitThumbnailUrl[3]},${splitThumbnailUrl[4]}${textColor}",
                VolleyService.imageLoader)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val example = inflater.inflate(R.layout.item_color_recycle_view, parent, false)
        return mViewHolder(example)
    }

    override fun getItemCount() = colorData.size

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        val colors = colorData[position]

        holder.itemView.setOnClickListener {
            onClickListener.onClick(colors)
        }
        holder.bind(colorData[position])
    }

    class OnClickListener(val clickListener: (colors: Colors) -> Unit) {
        fun onClick(colors: Colors) = clickListener(colors)
    }
}
