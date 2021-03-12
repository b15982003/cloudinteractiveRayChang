package com.example.cloudinteractiveraychang.base

import com.example.cloudinteractiveraychang.data.Colors

abstract class BaseModel {

    var onListener: OnListener? = null

    interface OnListener {
        fun onConnectionSuccess(colorData: List<Colors>) // 連線成功
    }

    protected open fun onConnectionSuccess(colorData: List<Colors>) {
    }

   fun  setOnListener(basePresenter: BasePresenter) {
       onListener = basePresenter

   }
}