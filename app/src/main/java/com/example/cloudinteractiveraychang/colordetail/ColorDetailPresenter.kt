package com.example.cloudinteractiveraychang.colordetail

import android.os.Message
import com.example.cloudinteractiveraychang.base.BasePresenter

class ColorDetailPresenter(val view: ColorDetailView, override val  model: ColorDetailModel) : BasePresenter(model) {

    fun getcolor(thumbnailUrl: String){
        model.getcolor(thumbnailUrl)
    }

    override fun onImageSuccess(msg: Message) {
        view.setImage(msg)
    }

}