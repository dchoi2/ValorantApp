package com.danielchoi.valorantapp.modelsW

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Skin(
    val displayIcon: String?,
    val displayName: String
) :Parcelable