package com.example.cloudinteractiveraychang.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.*
import java.net.URL

class URLtoBitmapUtil {

    private lateinit var job : Job
    companion object {
        val instance = URLtoBitmapUtil()
    }
    fun get(url: URL, task: URLtoBitmapTaskFinish) {
        job = GlobalScope.launch(Dispatchers.IO) {
            try {
                val urlopen = url.openConnection()
                urlopen.addRequestProperty("User-Agent"
                    ,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36")
                val bitmap = BitmapFactory.decodeStream(urlopen.getInputStream())
                task.onFinish(bitmap)
            }catch (e :Exception){
                task.onFinish(null)
            }finally {
                this.cancel()
            }
        }
    }

    interface URLtoBitmapTaskFinish{
        fun onFinish(data: Bitmap?)
    }
}