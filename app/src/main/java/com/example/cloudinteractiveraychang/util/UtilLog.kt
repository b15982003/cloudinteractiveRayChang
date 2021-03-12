package com.example.cloudinteractiveraychang.util

import android.util.Log

object UtilLog {
    private val isDebug: Boolean = true
    private val TAG: String = "Ray"
    // d
    fun d(msg: String) {
        if (isDebug) {
            Log.d(TAG, msg)
        }
    }
    // e
    fun e(msg: String) {
        if (isDebug) {
            Log.e(TAG, msg)
        }
    }
    // v
    fun v(msg: String) {
        if (isDebug) {
            Log.v(TAG, msg)
        }
    }
}