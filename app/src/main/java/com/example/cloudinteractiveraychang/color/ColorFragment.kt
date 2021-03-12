package com.example.cloudinteractiveraychang.color

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudinteractiveraychang.MainActivity
import com.example.cloudinteractiveraychang.R
import com.example.cloudinteractiveraychang.data.Colors

/**
 * 顏色總攬
 */

class ColorFragment : Fragment(), ColorView {

    private lateinit var presenter: ColorPresenter
    private lateinit var reColor: RecyclerView
    private lateinit var loadingDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ColorPresenter(this, ColorModel(MainActivity()))
        presenter.onCreate()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_color, container, false)
        reColor = view.findViewById(R.id.reColor)
        setLoadingDialogs()
        presenter.requestGetColors()

        return view
    }

    override fun setColorData(alColor: List<Colors>) {
        reColor.adapter = ColorAdapter(alColor, ColorAdapter.OnClickListener {
            val action = ColorFragmentDirections.actionGlobalColorDetailFragment(it)
            findNavController().navigate(action)
        })
    }

    override fun showLoadingDialog() {
        loadingDialog.show()
    }

    override fun closeLoadingDialog() {
        loadingDialog.dismiss()
    }

    fun setLoadingDialogs() {
        loadingDialog = ProgressDialog(context)
        loadingDialog.setTitle("讀取中")
        loadingDialog.setMessage("等待中...")
    }
}