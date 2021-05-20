package com.danielchoi.valorantapp.modelsA

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ability(
    val description: String,
    val displayIcon: String?,
    val displayName: String,
    val slot: String
) : Parcelable