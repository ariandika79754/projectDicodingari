package com.dicoding.mysubmissionapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val name: String,
    val nickname: String,
    val description: String,
    val generation: Int,
    val label: String,
    val photo: Int
) : Parcelable