package com.danielchoi.valorantapp.modelsW

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShopData(
    val category: String,
    val categoryText: String,
    val cost: Int
) : Parcelable
