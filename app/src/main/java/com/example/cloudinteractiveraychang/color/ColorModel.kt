package com.example.cloudinteractiveraychang.color

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.cloudinteractiveraychang.MainActivity
import com.example.cloudinteractiveraychang.base.BaseModel
import com.example.cloudinteractiveraychang.data.Colors
import com.example.cloudinteractiveraychang.network.VolleyService
import com.example.cloudinteractiveraychang.util.UtilLog
import com.google.gson.Gson


class ColorModel(mainActivity: MainActivity) : BaseModel() {

    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    fun getPhotosResult(): List<Colors> {
        val url = "$BASE_URL/photos"
        val list = mutableListOf<Colors>()
        val stringRequest =
            StringRequest(
                Request.Method.GET, url, Response.Listener<String> { response ->
                    val colors: List<Colors> =
                        Gson().fromJson(response, Array<Colors>::class.java).toList()
                    colors.forEach { postsResp ->
                        list.add(postsResp)
                    }
                    onConnectionSuccess(list)
                },

                Response.ErrorListener { error ->
                })

        VolleyService.requestQueue.add(stringRequest)
        VolleyService.requestQueue.start()

        return list
    }

    override fun onConnectionSuccess(colorData: List<Colors>) {
        super.onConnectionSuccess(colorData)
        UtilLog.d("model = ${colorData[1]}")
        onListener?.onConnectionSuccess(colorData)
    }

}
