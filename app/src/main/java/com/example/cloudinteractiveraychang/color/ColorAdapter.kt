package com.example.cloudinteractiveraychang.color

import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudinteractiveraychang.R
import com.example.cloudinteractiveraychang.data.Colors
import com.example.cloudinteractiveraychang.network.URLtoBitmapUtil
import java.net.URL

class ColorAdapter(
    private val colorData: List<Colors>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<ColorAdapter.mViewHolder>() {

    inner class mViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.tvId)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val background: ImageView = itemView.findViewById(R.id.ivBackground)

        fun bind(item: Colors) {
            val uiHandler: Handler = object : Handler(Looper.getMainLooper()){
                override fun handleMessage(msg: Message) {
                    when (msg.what) {
                        1 -> {
                            background.layoutParams.height = itemView.width
                            background.setImageBitmap(msg.obj as Bitmap)
                            id.text = item.id.toString()
                            title.text = item.title
                        }
                    }
                }
            }

            URLtoBitmapUtil.instance.get(
                URL(colorData[position].thumbnailUrl)
                ,object :URLtoBitmapUtil.URLtoBitmapTaskFinish{
                    override fun onFinish(data: Bitmap?) {
                        val msg = Message()
                        msg.what = 1
                        msg.obj = data
                        uiHandler.sendMessage(msg)
                    }
                })
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





