package com.example.cloudinteractiveraychang.color

import android.os.Message
import com.example.cloudinteractiveraychang.base.BasePresenter
import com.example.cloudinteractiveraychang.data.Colors

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

    override fun onImageSuccess(msg: Message) {
        TODO("Not yet implemented")
    }
}