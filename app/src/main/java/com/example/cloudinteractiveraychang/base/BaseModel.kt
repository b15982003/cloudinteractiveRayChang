package com.example.cloudinteractiveraychang.base

import android.os.Message
import com.example.cloudinteractiveraychang.data.Colors

abstract class BaseModel {

    var onListener: OnListener? = null

    interface OnListener {
        fun onConnectionSuccess(colorData: List<Colors>) // 連線成功

        fun onImageSuccess(msg: Message) // 圖片下載成功
    }

    protected open fun onConnectionSuccess(colorData: List<Colors>) {
    }

    protected open fun onImageSuccess(msg: Message) {
    }

   fun  setOnListener(basePresenter: BasePresenter) {
       onListener = basePresenter
   }
}