package com.example.cloudinteractiveraychang.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Colors(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) : Parcelable