package com.example.cloudinteractiveraychang.colordetail

import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.cloudinteractiveraychang.MainActivity
import com.example.cloudinteractiveraychang.base.BaseModel
import com.example.cloudinteractiveraychang.network.URLtoBitmapUtil
import java.net.URL

class ColorDetailModel(mainActivity: MainActivity): BaseModel() {

    fun getcolor(thumbnailUrl: String) {
        val uiHandler: Handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    1 -> {
                        onImageSuccess(msg)
                    }
                }
            }
        }

        URLtoBitmapUtil.instance.get(
            URL(thumbnailUrl)
            , object : URLtoBitmapUtil.URLtoBitmapTaskFinish {
                override fun onFinish(data: Bitmap?) {
                    val msg = Message()
                    msg.what = 1
                    msg.obj = data
                    uiHandler.sendMessage(msg)
                }
            })
    }

    override fun onImageSuccess(msg: Message) {
        super.onImageSuccess(msg)
        onListener?.onImageSuccess(msg)
    }
}