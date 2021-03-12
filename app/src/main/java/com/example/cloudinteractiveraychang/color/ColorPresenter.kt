package com.example.cloudinteractiveraychang.color

import com.example.cloudinteractiveraychang.base.BasePresenter
import com.example.cloudinteractiveraychang.data.Colors
import com.example.cloudinteractiveraychang.util.UtilLog

class ColorPresenter(val view: ColorView, override val model: ColorModel) : BasePresenter(model) {

    lateinit var alColor: List<Colors>

    fun requestGetColors() {
        model.getPhotosResult()
        view.showLoadingDialog()
    }

    override fun onConnectionSuccess(colorData: List<Colors>) {
        super.onConnectionSuccess(colorData)
        view.closeLoadingDialog()
        alColor = colorData
        view.setColorData(alColor)
    }
}