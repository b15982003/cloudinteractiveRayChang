package com.example.cloudinteractiveraychang.base

import android.os.Message
import com.example.cloudinteractiveraychang.data.Colors
import com.example.cloudinteractiveraychang.util.UtilLog

open class BasePresenter(open val model : BaseModel) : BaseModel.OnListener {

    override fun onConnectionSuccess(colorData: List<Colors>) {
        UtilLog.d("data1 = $colorData")
    }

    override fun onImageSuccess(msg: Message) {
        UtilLog.d("Ray+Msg3 = $msg")

    }

    fun onCreate(){
        model.setOnListener(this)
    }
}


