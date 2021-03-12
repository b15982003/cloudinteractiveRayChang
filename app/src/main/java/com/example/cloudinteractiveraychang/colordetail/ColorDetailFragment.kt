package com.example.cloudinteractiveraychang.colordetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.android.volley.toolbox.NetworkImageView
import com.example.cloudinteractiveraychang.MainActivity
import com.example.cloudinteractiveraychang.R
import com.example.cloudinteractiveraychang.network.VolleyService
import com.example.cloudinteractiveraychang.util.Util
import com.example.cloudinteractiveraychang.util.UtilLog

/**
 * 顏色詳細資訊
 */
class ColorDetailFragment : Fragment(), ColorDetailView {

    private lateinit var presenter: ColorDetailPresenter
    private lateinit var ivBackground: NetworkImageView
    private lateinit var tvId: TextView
    private lateinit var tvTitle: TextView
    private lateinit var rlBackground: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ColorDetailPresenter(this, ColorDetailModel(MainActivity()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_color_detail, container, false)
        ivBackground = view.findViewById(R.id.ivBackground)
        tvId = view.findViewById(R.id.tvId)
        tvTitle = view.findViewById(R.id.tvTitle)
        rlBackground = view.findViewById(R.id.rlBackground)

        val colorsArgs = ColorDetailFragmentArgs.fromBundle(
            requireArguments()
        ).colorkey
        tvId.text = colorsArgs.id.toString()
        tvTitle.setText(colorsArgs.title)
        rlBackground.setOnClickListener {
            findNavController().navigateUp()
        }

        val splitThumbnailUrl = Util.splitUrl(colorsArgs.thumbnailUrl, "/")
        val textColor = "?f=#E8E8E4"

        ivBackground.setImageUrl(
            "https://ipsumimage.appspot.com/${splitThumbnailUrl[3]},${splitThumbnailUrl[4]}${textColor}",
            VolleyService.imageLoader
        )
        return view
    }
}