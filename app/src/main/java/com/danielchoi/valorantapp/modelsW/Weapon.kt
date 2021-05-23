package com.danielchoi.valorantapp.modelsW

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weapon(
    val displayIcon: String,
    val displayName: String,
    val shopData: ShopData?,
    val skins: List<Skin>,
    val weaponStats: WeaponStats?
) : Parcelable