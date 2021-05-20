package com.danielchoi.valorantapp.modelsA

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Agent(
    val abilities: List<Ability>,
    val assetPath: String,
    val description: String,
    val developerName: String,
    val displayIcon: String,
    val displayIconSmall: String,
    val displayName: String,
    val fullPortrait: String?,
    val isAvailableForTest: Boolean?,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean?,
    val killfeedPortrait: String,
    val uuid: String
) : Parcelable