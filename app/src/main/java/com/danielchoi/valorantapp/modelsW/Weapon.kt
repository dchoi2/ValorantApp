package com.danielchoi.valorantapp.modelsW

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weapon(
    val category: String,
    val displayIcon: String,
    val displayName: String,
    val shopData: ShopData,
    val skins: List<Skin>,
    val uuid: String,
    val weaponStats: WeaponStats
) : Parcelable