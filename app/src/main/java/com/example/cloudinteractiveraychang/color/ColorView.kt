package com.example.cloudinteractiveraychang.color

import com.example.cloudinteractiveraychang.data.Colors

interface ColorView {
    fun setColorData(alcolor : List<Colors>)

    fun showLoadingDialog()

    fun closeLoadingDialog()
}