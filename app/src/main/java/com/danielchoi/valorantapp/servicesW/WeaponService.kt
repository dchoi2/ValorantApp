package com.danielchoi.valorantapp.servicesW

import com.danielchoi.valorantapp.modelsW.WeaponWrapper
import retrofit2.Call
import retrofit2.http.GET

interface WeaponService {

    @GET("weapons")
    fun getWeaponList () : Call<WeaponWrapper>
}
