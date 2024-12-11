package com.dicoding.mysubmissionapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AboutMe (
    val name: String,
    val email: String,
    val photo: Int
) : Parcelable

