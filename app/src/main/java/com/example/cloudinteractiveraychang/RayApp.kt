package com.example.cloudinteractiveraychang

import android.app.Application
import com.example.cloudinteractiveraychang.network.VolleyService

class RayApp : Application() {
    override fun onCreate() {
        super.onCreate()
        VolleyService.initialize(this)
    }
}