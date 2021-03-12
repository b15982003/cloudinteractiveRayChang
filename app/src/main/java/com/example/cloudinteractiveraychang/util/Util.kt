package com.example.cloudinteractiveraychang.util

object Util {
    fun splitUrl(url: String, delimiters: String): List<String> {
        return url.split(delimiters)
    }
}