package com.danielchoi.valorantapp.modelsW

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeaponStats(
    val damageRanges: List<DamageRange>,
    val magazineSize: Int,
    val reloadTimeSeconds: Double
) : Parcelable