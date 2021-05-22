package com.danielchoi.valorantapp.modelsW

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DamageRange(
    val bodyDamage: Double,
    val headDamage: Double,
    val legDamage: Double,
    val rangeEndMeters: Int,
    val rangeStartMeters: Int
) :Parcelable