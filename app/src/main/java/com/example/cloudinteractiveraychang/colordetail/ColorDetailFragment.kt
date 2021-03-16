package com.example.cloudinteractiveraychang.colordetail

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.cloudinteractiveraychang.MainActivity
import com.example.cloudinteractiveraychang.R

/**
 * 顏色詳細資訊
 */
class ColorDetailFragment : Fragment(), ColorDetailView {

    private lateinit var presenter: ColorDetailPresenter
    private lateinit var ivBackground: ImageView
    private lateinit var tvId: TextView
    private lateinit var tvTitle: TextView
    private lateinit var rlBackground: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ColorDetailPresenter(this, ColorDetailModel(MainActivity()))
        presenter.onCreate()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_color_detail, container, false)
        val colorsArgs = ColorDetailFragmentArgs.fromBundle(requireArguments()).colorkey

        ivBackground = view.findViewById(R.id.ivBackground)
        tvId = view.findViewById(R.id.tvId)
        tvTitle = view.findViewById(R.id.tvTitle)
        rlBackground = view.findViewById(R.id.rlBackground)

        tvId.text = colorsArgs.id.toString()
        tvTitle.setText(colorsArgs.title)
        rlBackground.setOnClickListener {
            findNavController().navigateUp()
        }

        presenter.getcolor(colorsArgs.thumbnailUrl)

        return view
    }

    override fun setImage(msg: Message) {
        ivBackground.setImageBitmap(msg.obj as Bitmap)
    }
}