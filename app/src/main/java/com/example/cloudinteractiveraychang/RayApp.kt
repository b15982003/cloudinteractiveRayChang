package com.example.cloudinteractiveraychang

import android.app.Application
import com.example.cloudinteractiveraychang.network.VolleyService
import kotlin.properties.Delegates

class RayApp : Application() {
    override fun onCreate() {
        super.onCreate()
        VolleyService.initialize(this)
        instance=this;
    }

    companion object {

        var instance: RayApp by Delegates.notNull()

    }
}